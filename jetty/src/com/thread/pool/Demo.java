package com.thread.pool;

import java.util.HashMap;
import java.util.Map;

public class Demo {
	
	
	public static void main(String[] args) throws Exception {
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		
//		Thread.sleep(1*1000);
		t2.start();
			
	}
}
