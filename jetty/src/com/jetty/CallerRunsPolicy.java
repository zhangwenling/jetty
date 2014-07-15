package com.jetty;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallerRunsPolicy implements RejectedExecutionHandler {

	private LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();

	/**
	 * Creates a <tt>CallerRunsPolicy</tt>.
	 */
	public CallerRunsPolicy() {
	}

	/**
	 * Executes task r in the caller's thread, unless the executor has been shut
	 * down, in which case the task is discarded.
	 * 
	 * @param r
	 *            the runnable task requested to be executed
	 * @param e
	 *            the executor attempting to execute this task
	 */
	public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {

		if (!e.isShutdown()) {
			e.setMaximumPoolSize(e.getMaximumPoolSize() + Runtime.getRuntime().availableProcessors());
			try {
				e.awaitTermination(60L, TimeUnit.MILLISECONDS);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("线程数量过载...");
			e.execute(r);
		}
	}
}
