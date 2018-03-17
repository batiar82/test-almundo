package service;

import dao.EmployeeDao;
import dao.impl.MemoryEmployeeDaoImpl;
/**
 * DaoFactory that generates a employee dao
 * @author Moreno Alvariza, Mariano
 *
 */
public class DaoFactory {
	public static final String MEMORY_DAO="MEMORY_DAO";
	/**
	 * Generates a Dao from a type
	 * @param type The type of DAO requested 
	 * @return An EmployeeDao.
	 */
	public static EmployeeDao getDao(String type) {
		//TODO Implement more DAOS
		return new MemoryEmployeeDaoImpl();
		
	}
}
