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
				p.print(i);
			}
		});
		
		Thread even = new Thread(() -> {
			for(int i=2;i<=100;i+=2) {
				p.print(i);
			}
		});
		
		odd.start();
		even.start();

	}

	private void print(int n) {
		synchronized (this) {
			System.out.println(n);
			this.notifyAll();
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
