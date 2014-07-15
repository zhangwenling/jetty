package com.jetty;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.tomcat.util.threads.TaskQueue;
import org.apache.tomcat.util.threads.TaskThreadFactory;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

public class ThreadTest {

	// 内部类
	private static class MyThread implements Runnable {

		private int i;

		public MyThread(int i) {
			this.i = i;
		}

		@Override
		public void run() {
			try {
				String ss = String
						.valueOf("dsffffdsfdsfsdfsdfdsfsdfdsssssfdsfdsfsdfsssssfdsfdsfsssssssssdsfdsfsdfssssfffsdfdfsfsfdsfdsfsdfdsfdsfsdfdsfsdfsdffffdsfdsfdsfdsfdsfsdfdsfdsfsdffdfsafasdfsafsdafffffdfdsfsfsffffffff"
								+ i);
				Thread.currentThread().sleep(10);
				System.out.println(Thread.currentThread().getName() + ":" + i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			// ExecutorService executorService =
			// Executors.newFixedThreadPool(1);
			// ExecutorService executorService =
			// Executors.newCachedThreadPool();
			Thread.currentThread().sleep(10000);
			ExecutorService executorService = Executors.newFixedThreadPool(10, new TaskThreadFactory("pref", true, 1));
			TaskQueue taskqueue = new TaskQueue(Integer.MAX_VALUE);
		        TaskThreadFactory tf = new TaskThreadFactory("pref", true, 1);
		        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20, 60L, TimeUnit.MILLISECONDS,taskqueue, tf);
			for (int i = 0; i < 10000; i++) {
				executorService.execute(new MyThread(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static class TaskThreadFactory implements ThreadFactory {
		private final ThreadGroup group;
		private final AtomicInteger threadNumber = new AtomicInteger(1);
		private final String namePrefix;
		private final boolean daemon;
		private final int threadPriority;

		public TaskThreadFactory(String namePrefix, boolean daemon, int priority) {
			SecurityManager s = System.getSecurityManager();
			group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
			this.namePrefix = namePrefix;
			this.daemon = daemon;
			this.threadPriority = priority;
		}

		@Override
		public Thread newThread(Runnable r) {
			TaskThread t = new TaskThread(group, r, namePrefix + threadNumber.getAndIncrement());
			t.setDaemon(daemon);
			t.setPriority(threadPriority);
			return t;
		}

	}

	public static class TaskThread extends Thread {

		private final long creationTime;

		public TaskThread(ThreadGroup group, Runnable target, String name) {
			super(group, target, name);
			this.creationTime = System.currentTimeMillis();
		}

		public TaskThread(ThreadGroup group, Runnable target, String name, long stackSize) {
			super(group, target, name, stackSize);
			this.creationTime = System.currentTimeMillis();
		}

		/**
		 * @return the time (in ms) at which this thread was created
		 */
		public final long getCreationTime() {
			return creationTime;
		}

	}
}