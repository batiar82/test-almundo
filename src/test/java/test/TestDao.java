package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.EmployeeDao;
import dao.factory.DaoFactory;
import model.impl.Operator;

public class TestDao {

	private EmployeeDao dao;
	@Before
	public void setUp() throws Exception {
		dao = DaoFactory.getDao(DaoFactory.MEMORY_DAO);
	}
	@Test
	public void testNotNullEmployee() {
		Assert.assertNotNull(dao.getFreeEmployee());
		
	}
	@Test
	public void tesOperatorEmployee() {
		Assert.assertEquals(dao.getFreeEmployee().getClass(), Operator.class);
		
	}


}
