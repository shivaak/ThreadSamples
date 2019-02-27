/**
 * @author shivaak on 25-Feb-2019
 *
 */
package com.learning;

/**
 * @author shivaak on 25-Feb-2019
 *
 */
class LazyThread extends Thread{
	
	@Override
	public void run() {
		
		try {
			for(int i=1;i<=10;i++) {
				System.out.println("Oyeeeeee.........");
				if(i==5)
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
public class InteruptExample {
	

	public static void main(String[] args) throws InterruptedException {
		LazyThread l = new LazyThread();
		l.start();
		//Thread.sleep(5000);
		
		l.interrupt(); // if this line executes first, then it will wait until l goes to wait state
		System.out.println("Main COmpleted");
	}
}
