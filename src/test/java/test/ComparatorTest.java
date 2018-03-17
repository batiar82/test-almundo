package test;

import static org.junit.Assert.*;

import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Employee;
import model.impl.Director;
import model.impl.Operator;
import model.impl.Supervisor;
/**
 * Tests to check {@link model.Employee.compareTo()}
 * @author Moreno Alvariza, Mariano
 *
 */
public class ComparatorTest {
	private Operator operator;
	private Supervisor supervisor;
	private Director director;
	PriorityQueue<Employee> pq;
	@Before
	public void setUp() throws Exception {
		operator=new Operator(1);
		supervisor=new Supervisor(2);
		director=new Director(3);
		pq = new PriorityQueue<Employee>();
		pq.add(director);
		pq.add(operator);
		pq.add(supervisor);
				
	}

	@Test
	public void testCompareTo() {
		Assert.assertNotNull("Error compareTo",operator.compareTo(director));
		Assert.assertTrue(operator.compareTo(director)==-1);
		Assert.assertTrue(operator.compareTo(supervisor)==-1);
		Assert.assertTrue(pq.poll().equals(operator));
	}
	@Test
	public void testPriorityQueue() {
		Assert.assertTrue(pq.poll().equals(operator));
		Assert.assertTrue(pq.poll().equals(supervisor));
		Assert.assertTrue(pq.poll().equals(director));
		
	}

}
