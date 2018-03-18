package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.Test;

import model.Call;
import model.Employee;
import model.impl.Operator;

public class TestThread {
	List<Call> tasks;
	List<Employee> employees;
	
	
	@Test
	public void test04() throws InterruptedException, ExecutionException {
	    test(4);
	}
	
	private void setUp(int threadCount) {
		tasks=new ArrayList<Call>();
		employees= new ArrayList<Employee>();
		for(int i=0;i<threadCount;i++) {
			Employee employee=new Operator(i);
			Call call=new Call(i,Duration.ofSeconds(5));
			call.setEmployee(employee);
			employees.add(employee);
			tasks.add(call);
		}
	}
	
	private void test(int threadCount) throws InterruptedException, ExecutionException {
		setUp(threadCount);
		ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
	    List<Future<Employee>> futures = executorService.invokeAll(tasks);
	    List<Employee> resultList = new ArrayList<Employee>(futures.size());
	    for (Future<Employee> future : futures) {
	        resultList.add(future.get());
	    }
	    Assert.assertEquals(threadCount, futures.size());
	    List<Employee> expectedList = new ArrayList<Employee>(threadCount);
	    for (Employee e: employees) {
	        expectedList.add(e);
	    }
	    Collections.sort(resultList);
	    Assert.assertEquals(expectedList, resultList);
	}
}
