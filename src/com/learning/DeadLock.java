/**
 * @author shivaak on 25-Feb-2019
 *
 */
package com.learning;

/**
 * @author shivaak on 25-Feb-2019
 *
 */


class MyThread extends Thread{
	Thread t;
	
	MyThread(Thread t){
		this.t = t;
	}
	
	@Override
	public void run() {
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class DeadLock {
	
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread(Thread.currentThread());
		t1.start();
		
		t1.join();
		
	}

}
