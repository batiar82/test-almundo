package test;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import model.Call;
import service.Dispatcher;

public class Runner {
	
	public static void main(String[] args) {
		Dispatcher dispatcher=new Dispatcher();
		for(int i=0;i<10;i++) {
			long duration=ThreadLocalRandom.current().nextLong(Call.MIN_DURATION, Call.MAX_DURATION+1);
			Call call=new Call(i,Duration.ofSeconds(duration));
			dispatcher.dispatchCall(call);
		}
		dispatcher.shutdown();
	}

}
