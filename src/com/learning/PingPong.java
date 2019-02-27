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
		System.out.print(msg);
	}
}

public class PingPong {

	public static void main(String[] args) {
		new PingPong().operate();
	}

	private void operate() {
		Printer p = new Printer();

		Thread ping = new Thread(() -> {
			
			
			synchronized (p) {
				for(int i = 1;i<=10;i++) {
					p.display("[ Ping ");
					p.notify();
					
					try {
						p.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

			}
			
		
		}, "ping");

		Thread pong = new Thread(() -> {
			
			synchronized (p) {
				try {
					p.wait(12000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i = 1;i<=10;i++) {
					p.display("Pong ]");		
					System.out.println();
					p.notify();
					try {
						if(i<10)
						p.wait();
						//Thread.sleep(300);					
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

			}
			
				
		}, "pong");
		
		try {
		
		pong.start();
		Thread.sleep(10000);
		ping.start();
		//p.notifyAll();
		
			ping.join();
			pong.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
