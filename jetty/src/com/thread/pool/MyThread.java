package com.thread.pool;

import java.util.HashMap;
import java.util.Map;

public class MyThread extends Thread{
	
	public static Map map = new HashMap();
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " running");
			String name = Thread.currentThread().getName();
			synchronized (map) {
				if("t1".equals(name)){
					map.wait(3*1000);
				}
				if("t2".equals(name)){
					map.notifyAll();
				}
				map.put(Thread.currentThread().getId(), name);
				
				System.out.println(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
