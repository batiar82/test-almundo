package model;

import java.time.Duration;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
/**
 * A Call is a piece of work that enters the system to be processed by a {@link model.Employee}
 * @author Moreno Alvariza, Mariano
 *
 */
public class Call implements Callable<Employee>{
	final static Logger logger = Logger.getLogger(Call.class);
	
	public static final long MIN_DURATION=5L;
	public static final long MAX_DURATION=10L;
	
	/**
	 * Id of the call	
	 */
	private Integer id;
	/**
	 * Amount of time that an {@link model.Employee} will need to process the call
	 */
	private Duration duration;
	private Employee employee;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Duration getDuracion() {
		return duration;
	}
	public void setDuracion(Duration duration) {
		this.duration = duration;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	/**
	 * Contructor of a Call
	 * @param id Identified of object, must be unique
	 * @param duration Lenght of call in time
	 */
	public Call(Integer id, Duration duration) {
		super();
		this.id = id;
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Call [id=" + id + ", duration=" + duration.toMillis() + "]";
	}
	/**
	 * This method is going to be called when is being processed by a Employee 
	 * In this example will sleep the amount of time of the duration property.
	 */
	public Employee call() throws Exception {
		logger.info("Employee id: "+this.employee.getId()+" of class: "+this.employee.getClass()+" is about to answer the callId :"+this.id+" that lasts "+this.duration.getSeconds()+" seconds.");
		Thread.sleep(this.duration.toMillis());
		logger.info("Employee id: "+this.employee.getId()+" of class: "+this.employee.getClass()+" finished answering the callId :"+this.id+" that lasts "+this.duration.getSeconds()+" seconds.");
		return this.employee;
	}
	
}
