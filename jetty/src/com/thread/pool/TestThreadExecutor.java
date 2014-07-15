package com.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadExecutor {

	public static void main(String[] args) {
		int maxTimes = 500;
//		newSingleThreadExecutor(maxTimes);
//		newFixedThreadPool(maxTimes);
		newCachedThreadPool(maxTimes);
	}
	
	public static void newSingleThreadExecutor(int maxTimes){
		ExecutorService pool = Executors.newSingleThreadExecutor();

		for (int i = 0; i < maxTimes; i++) {
			pool.execute(new MyThread());
		}
		pool.shutdown();
	}
	public static void newFixedThreadPool(int maxTimes){
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < maxTimes; i++) {
			pool.execute(new MyThread());
		}
		pool.shutdown();
	}
	public static void newCachedThreadPool(int maxTimes){
		ExecutorService pool = Executors.newCachedThreadPool();
		
		for (int i = 0; i < maxTimes; i++) {
			pool.execute(new MyThread());
		}
		pool.shutdown();
	}
	
}
