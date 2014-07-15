package com.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
	public static final int MAX_POOL_SIZE = 100;
	private static ExecutorService exec_1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * MAX_POOL_SIZE);
	private static ExecutorService exec_2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * MAX_POOL_SIZE);

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 20; i++) {
			exec_1.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("------");
				}
			});
			exec_2.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("------");
				}
			});
		}
		
		System.err.println("end");
		Thread.sleep(5*1000);
		System.err.println("exec_1状态：" + exec_1.isShutdown());
		System.err.println("exec_2状态：" + exec_1.isShutdown());
		exec_1.shutdown();
		exec_2.shutdown();
		System.err.println("exec_1状态：" + Runtime.getRuntime());
		System.err.println("exec_2状态：" + exec_1.isShutdown());
	}

}
