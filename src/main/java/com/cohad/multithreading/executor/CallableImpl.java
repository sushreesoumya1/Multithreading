package com.cohad.multithreading.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Component;

@Component
public class CallableImpl {

	public void execute() {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		List<Future<String>> list= new ArrayList<>();
		for(int i=0; i<9;i++) {
			list.add(executor.submit(new CallableTask("Name-"+i)));
		}
		
		for(Future<String> s: list)
			try {
				System.out.println(s.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
	}
}
