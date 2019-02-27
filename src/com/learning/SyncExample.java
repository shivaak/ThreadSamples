/**
 * @author shivaak on 25-Feb-2019
 *
 */
package com.learning;

/**
 * @author shivaak on 25-Feb-2019
 *
 */
class Display {
	
	public synchronized void display(String name) {
		for(int i=1;i<=10;i++) {
			System.out.print("Good Morning : ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
}

class MyDThread extends Thread {
	Display d;
	String name;
	MyDThread(Display d, String name){
		this.d = d ;
		this.name = name;
	}
	
	@Override
	public void run() {
		d.display(name);
	}
}

public class SyncExample {

	public static void main(String[] args) throws InterruptedException {
		Display d = new Display();
		
		MyDThread t1 = new MyDThread(d, "Dhoni");
		t1.start();
		//t1.join();
		
		MyDThread t2 = new MyDThread(d, "Raina");
		t2.start();
		//t2.join();
		
		MyDThread t3 = new MyDThread(d, "Kholi");
		t3.start();
		//t3.join();
		
	}
}
