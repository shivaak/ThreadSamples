/**
 * @author shivaak on 27-Feb-2019
 *
 */
package com.learning;

/**
 * @author shivaak on 27-Feb-2019
 *
 */

class Printer {
	public void display(String msg) {
		synchronized (this) {
			for(int i = 1;i<=10;i++) {
				System.out.print(msg);
				if(Thread.currentThread().getName().equals("pong")) {
					System.out.println();
				}
				this.notify();
				try {
					this.wait();
					Thread.sleep(300);					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}
	}
}

public class PingPong {

	public static void main(String[] args) {
		new PingPong().operate();
	}

	private void operate() {
		Printer p = new Printer();

		Thread ping = new Thread(() -> {
			p.display("[ Ping ");
		}, "ping");

		Thread pong = new Thread(() -> {
			p.display("Pong ]");			
		}, "pong");

		ping.start();
		pong.start();

		try {
			ping.join();
			pong.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
