package com.cohad.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

@Component
public class SingleThreadExecutor {
	
	public void execute() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for(int i=0;i<3;i++)
			executor.execute(new Task(i));
	}
}
