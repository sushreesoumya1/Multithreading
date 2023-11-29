package com.cohad.multithreading.InterThreadCommunication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomLocks {
	
	List<Integer> list = new ArrayList<Integer>();
	private Object lock= new Object();
	int value=0;
	public void execute() {
		System.out.println("yes");
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		t1.start();
		t2.start();
	}
	
	private void producer() throws InterruptedException {
		System.out.println("PRODUCER");
		synchronized(lock) {
			while(true) {
				if(value<5) {
					System.out.println("added: "+value);
					list.add(value++);
					lock.notify();
					
				}
				else
					lock.wait();
					
			}
		}
		
		
	}
	
	private void consumer() throws InterruptedException {
		System.out.println("CONSUMER");
		synchronized(lock) {
			while(true) {
				if(value>0) {
					System.out.println("removed: "+value);
					list.remove(value--);
					lock.notify();
				}
				else
					lock.wait();
				
				
			}
		}
		
	}

}
