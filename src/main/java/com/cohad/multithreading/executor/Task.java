package com.cohad.multithreading.executor;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
	int id;
	
	public Task(int id) {
		this.id=id;
	}

	@Override
	public void run() {

		System.out.println("Task id: "+id);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
