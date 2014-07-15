package com.jetty;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建应用线程池单例管理类
 * 
 * @author CHENLEI
 * 
 */
public class PoolThreadManager {

	private final static PoolThreadManager poolThread = new PoolThreadManager();

	ThreadPoolExecutor executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, Runtime.getRuntime().availableProcessors() * 8, 20L,
			TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(200), new ThreadPoolExecutor.CallerRunsPolicy());

	private PoolThreadManager() {
		executorService.allowCoreThreadTimeOut(true);
	}

	/**
	 * 获得线程管理类
	 * 
	 * @return
	 */
	public static PoolThreadManager getInstance() {
		return poolThread;
	}

	/**
	 * 将任务放入线程池
	 * 
	 * @param command
	 */
	public void execute(Runnable command) {
		executorService.execute(command);
	}

}
