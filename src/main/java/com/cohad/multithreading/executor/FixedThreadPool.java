package com.cohad.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

@Component
public class FixedThreadPool {

	public void execute() {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++) {
			executor.execute(new Task(i));
		}
	}
}
