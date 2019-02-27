/**
 * @author shivaak on 24-Feb-2019
 *
 */
package com.learning;

/**
 * @author shivaak on 24-Feb-2019
 *
 */

class MyThread1 extends Thread{

	Thread other;
	MyThread1(Thread other){
		this.other = other;
	}
	
	@Override
	public void run() {
		try {
			for(int i=1;i<=10;i++) {
				System.out.println("Child Thread 1");
				//			System.out.println(Thread.currentThread().getName());
				//Thread.sleep(30);

			}
			other.join();
			System.out.println("1st Thread completed");
		}catch(InterruptedException ex) {
System.out.println(ex);
		}
	}
}

class MyThread2 extends Thread{
	

	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("Child Thread 2");
			//			System.out.println(Thread.currentThread().getName());
			Thread.yield();

		}
	}
}
public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {

		MyThread2 t2 = new MyThread2();
		
		MyThread1 t1 = new MyThread1(t2);
//	t1.setPriority(Thread.MAX_PRIORITY);
		

		
	//	t2.setPriority(Thread.MIN_PRIORITY);
		t2.start();
		t1.start();
		/*System.out.println(Thread.currentThread().getName());
		for(int i=1;i<=10;i++) {
			System.out.println("Main Thread");
			//Thread.sleep(30);
		}
		 */
		t1.interrupt();
		t1.join();
		t2.join();
		System.out.println("Completed");
	}

}
