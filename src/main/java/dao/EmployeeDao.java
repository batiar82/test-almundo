package dao;

import java.util.concurrent.Future;

import model.Employee;

public interface EmployeeDao {
	/**
	 * Get a free employee 
	 * 1) {@link model.impl.Operator}
	 * 2) {@link model.impl.Supervisor}
	 * 3) {@link model.impl.Director}
	 * @return A free employee, null if there are none free.
	 */
	public Employee getFreeEmployee();
	/**
	 * Sets a {@link java.util.concurrent.Future} to free a employee when its finished.
	 * @param future {@link java.util.concurrent.Future} to async check the ending of a call and to retrieve a free Employee
	 */
	public void setFutureToEmployee(Future<Employee> future);
	
	/**
	 * Reinitializes the employee pool acording to the provided parameters
	 * @param operatorQty The amount of Employees of type {@link model.impl.Operator}
	 * @param supervisorQty The amount of Employees of type {@link model.impl.Operator}
	 * @param directorQty The amount of Employees of type {@link model.impl.Operator}
	 */
	public void reinitialize(int operatorQty, int supervisorQty, int directorQty);
}
