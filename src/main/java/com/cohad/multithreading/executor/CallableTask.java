package com.cohad.multithreading.executor;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {

	String name;
	public CallableTask(String name) {
		this.name=name;
	}
	@Override
	public String call() throws Exception {
		return name+" from thread id="+Thread.currentThread().getId();
	}
	
}
