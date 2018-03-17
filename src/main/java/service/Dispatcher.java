package service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import dao.EmployeeDao;
import dao.factory.DaoFactory;
import model.Call;
import model.Employee;
/**
 * A dispatcher takes Calls and assign them to a {@link model.Employee} in order to process them.
 * Once the call has an Employee set, is then put in a Queue that will spawn an amount of threads
 * @author Moreno Alvariza, Mariano
 *
 */
public class Dispatcher {
	
	final static Logger logger = Logger.getLogger(Dispatcher.class);
	
	private static final int MAX_CONCURRENT_CALLS=10;
	private static final int WAIT_TIME_STRATEGY=1000;
	private ExecutorService executorService;
	
	private EmployeeDao employeeDao;
	
	/**
	 * Entry point of the dispatcher to process a {@link model.Call}
	 * @param call The call to be asigned to a Employee and enqueued
	 */
	public void dispatchCall(Call call) {
		Employee op=null;
		while(op==null) {
			op= employeeDao.getFreeEmployee();
			waitStrategy(op);
		}
		call.setEmployee(op);
		logger.debug("Adding call to pool and show queue info: "+this.executorService.toString());
		employeeDao.setFutureToEmployee(this.executorService.submit(call));
		
	}
	
	private void waitStrategy(Employee employee) {
		if(employee==null)
			try {
				Thread.sleep(Dispatcher.WAIT_TIME_STRATEGY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	
	/**
	 * Default constructor for the dispatcher
	 */
	public Dispatcher() {
		this.executorService = Executors.newFixedThreadPool(Dispatcher.MAX_CONCURRENT_CALLS);
		employeeDao=DaoFactory.getDao(DaoFactory.MEMORY_DAO);	
	}
	/**
	 * Class constructor using fields
	 * @param operatorQty The amount of Employees of type {@link model.impl.Operator}
	 * @param supervisorQty The amount of Employees of type {@link model.impl.Operator}
	 * @param directorQty The amount of Employees of type {@link model.impl.Operator}
	 */
	public Dispatcher(int operatorQty, int supervisorQty, int directorQty) {
		this.executorService = Executors.newFixedThreadPool(Dispatcher.MAX_CONCURRENT_CALLS);
		employeeDao=DaoFactory.getDao(DaoFactory.MEMORY_DAO);
		employeeDao.reinitialize(operatorQty, supervisorQty, directorQty);
	}
	
	
	/**
	 * Method to tell the dispatcher to close the queue 
	 */
	public void shutdown() {
		logger.debug("Shutting down Dispatcher");
		executorService.shutdown();
	}
	
	
}