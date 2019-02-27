/**
 * @author shivaak on 27-Feb-2019
 *
 */
package com.learning;

/**
 * @author shivaak on 27-Feb-2019
 *
 */

public class OddEvenThread {

	public static void main(String[] args) {
		printNumber();
	}

	private static void printNumber() {

		OddEvenThread p = new OddEvenThread();

		Thread odd = new Thread(() -> {
			for(int i=1;i<=100;i+=2) {
				synchronized (p) {
					System.out.println(i);
					p.notify();
					try {
						p.wait();
						//Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		Thread even = new Thread(() -> {
			try {
				synchronized (p) {
					p.wait(100);
					for(int i=2;i<=100;i+=2) {
						System.out.println(i);
						p.notify();
						if(i<100)
							p.wait();
						//Thread.sleep(1000);
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		even.start();
		odd.start();
	

	}


}
