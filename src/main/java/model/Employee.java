package model;

import model.impl.Director;
import model.impl.Operator;
import model.impl.Supervisor;

/**
 * Employee superclass, and Employee is responsible to take calls and is assigned by a {@link service.Dispatcher}
 * @author Moreno Alvariza, Mariano
 *
 */
public abstract class Employee implements Comparable<Employee>{
	private Integer id;
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Constructor of a Employee
	 * @param id Identifier of an Employee must be unique.
	 */
	public Employee(Integer id) {
		super();
		this.id = id;
	}
	@Override
	public int compareTo(Employee o) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
		if (this.id==o.getId())
			return EQUAL;
		else {
			if(this.getClass().equals(o.getClass())){
				return (this.id < o.getId()) ? BEFORE : AFTER;
			}else {
				if(this.getClass().equals(Operator.class)) return BEFORE;
				if(this.getClass().equals(Director.class)) return AFTER;
				if(this.getClass().equals(Supervisor.class)) {
					if(o.getClass().equals(Director.class)) 
						return BEFORE;
					else
						return AFTER;
				}						
			}
		}
		//default
		return BEFORE;
				
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", getClass()=" + getClass() + "]";
	}
	
}
