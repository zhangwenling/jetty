package com.thread.pool;

public class MyThreadDemo implements Runnable {

	private String name;
	private Object self;

	private MyThreadDemo(String name, Object self) {
		this.name = name;
		this.self = self;
	}

	@Override
	public void run() {
		int count = 10;
		synchronized (self) {
			try {
				String name = Thread.currentThread().getName();
				if(name.equals("Thread-0")){
					self.wait(3*1000);
				}
				System.out.print(name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			self.notify();
		}
	}

	public static void main(String[] args) throws Exception {
		/*Object a = new Object();
		MyThreadDemo pa = new MyThreadDemo("A", a);
		MyThreadDemo pb = new MyThreadDemo("B", a);
		MyThreadDemo pc = new MyThreadDemo("C", a);

		new Thread(pa).start();
		new Thread(pb).start();
		new Thread(pc).start();*/
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the self
	 */
	public Object getSelf() {
		return self;
	}

	/**
	 * @param self the self to set
	 */
	public void setSelf(Object self) {
		this.self = self;
	}
}
