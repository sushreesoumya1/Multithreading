package com.cohad.multithreading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cohad.multithreading.InterThreadCommunication.CustomLocks;
import com.cohad.multithreading.executor.CallableImpl;
import com.cohad.multithreading.executor.FixedThreadPool;
import com.cohad.multithreading.executor.ScheduledThreadPool;
import com.cohad.multithreading.executor.SingleThreadExecutor;


@RestController
public class Cotroller {
	
	@Autowired
	CustomLocks customLocks;
	@Autowired
	SingleThreadExecutor singleThreadExecutor;
	@Autowired
	FixedThreadPool fixedThreadPool;
	@Autowired
	ScheduledThreadPool scheduledThreadPool;
	@Autowired
	CallableImpl callableImpl;
	
	@GetMapping
	public void operation() {
		//customLocks.execute();
		//singleThreadExecutor.execute();
		//fixedThreadPool.execute();
		//scheduledThreadPool.execute();
		callableImpl.execute();
	}

}
