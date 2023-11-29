package com.cohad.multithreading.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class ScheduledThreadPool {
	
	public void execute() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
		
		//for(int i=0;i<9;i++)
		executor.scheduleAtFixedRate(new Task(1), 1000, 1000, TimeUnit.MILLISECONDS);
		
		executor.shutdown();
		try {
			if(executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			executor.shutdownNow();
		}
	}

}
