package model.impl;

import model.Employee;
/**
 * A director is a type of {@link model.Employee} it will be picked last in order to process a {@link model.Call}
 * @author Moreno Alvariza, Mariano
 *
 */
public class Director extends Employee {

	public Director(int id) {
		super(id);
	}

}
