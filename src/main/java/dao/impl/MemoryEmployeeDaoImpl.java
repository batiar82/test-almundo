package dao.impl;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import dao.EmployeeDao;
import model.Call;
import model.Employee;
import model.impl.Director;
import model.impl.Operator;
import model.impl.Supervisor;

public class MemoryEmployeeDaoImpl implements EmployeeDao{
	
	final static Logger logger = Logger.getLogger(MemoryEmployeeDaoImpl.class);
	//Default employees of every kind
	private int operatorQty=5;
	private int supervisorQty=3;
	private int directorQty=2;
	//The queue of free employees
	private Queue<Employee> employees;
	//A set to store responses from every call that in enqueued and free the employee afterwards.
	private Set<Future<Employee>> futures=new HashSet<Future<Employee>>();
	
	@Override
	public Employee getFreeEmployee() {
		checkEndedFutures();
		Employee free=employees.poll();
		logger.debug("Employee to return: "+free);
		return free;
	}

	@Override
	public void setFutureToEmployee(Future<Employee> future) {
		futures.add(future);
		
	}

	private void generateEmployees() {
		int empIdCounter=1;
		employees=new PriorityQueue<Employee>();
		Employee aEmployee;
		/*Creating Operators*/
		for(int i=0;i<this.operatorQty;i++) {
			aEmployee=new Operator(empIdCounter);
			employees.add(aEmployee);
			empIdCounter++;
		}
		/*Creating Supervisors*/
		for(int i=0;i<this.supervisorQty;i++) {
			aEmployee=new Supervisor(empIdCounter);
			employees.add(aEmployee);
			empIdCounter++;
		}
		/*Creating Directors*/
		for(int i=0;i<this.directorQty;i++) {
			aEmployee=new Director(empIdCounter);
			employees.add(aEmployee);
			empIdCounter++;
		}		
	}
	private void checkEndedFutures() {
		logger.debug("Checking for finished Employees on Futures list");
		futures.removeIf(aFuture -> {
			if(aFuture.isDone()) {
				try {
					Employee finishedEmp=aFuture.get();
					logger.debug("Adding "+finishedEmp+" to the queue");
					employees.add(finishedEmp);
					
				}catch(InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
				
				return true;
			}else return false;
		});
		
	}
	
	public MemoryEmployeeDaoImpl() {
		generateEmployees();
		
	}

	@Override
	public void reinitialize(int operatorQty, int supervisorQty, int directorQty) {
		this.operatorQty=operatorQty;
		this.supervisorQty=supervisorQty;
		this.directorQty=directorQty;
		generateEmployees();
		
	}
}
