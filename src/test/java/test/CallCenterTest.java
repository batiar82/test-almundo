package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Call;
import service.Dispatcher;

public class CallCenterTest {

	private Dispatcher dispatcher;
	private List<Call> calls;
	private static final int NUM_CALLS=10;
	@Before
	public void dispatcherSetUp() {
		dispatcher=new Dispatcher();
		calls=new ArrayList<Call>();
		for(int i=0;i<CallCenterTest.NUM_CALLS;i++) {
			long duration=ThreadLocalRandom.current().nextLong(Call.MIN_DURATION, Call.MAX_DURATION+1);
			Call call=new Call(i,Duration.ofSeconds(duration));
			//Add call to list of calls to process
			calls.add(call);
		}
	}
	@Test
	public void test() {
		Assert.assertNotNull("Dispatcher cannot be null", dispatcher);
		Assert.assertNotNull("Calls cannot be null", calls);
		for(Call call : calls) {
			dispatcher.dispatchCall(call);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@After
	public void dispatcherShutdown() {
		try {
			Thread.sleep((NUM_CALLS+1)*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher.shutdown();
	}

}
