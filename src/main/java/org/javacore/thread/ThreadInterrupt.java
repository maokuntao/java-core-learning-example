package org.javacore.thread;

/**
 * <pre>
 * 线程中断案例
 * </pre>
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {

		Thread inThread = new Thread(new InterrupThread());
		inThread.start();

		Thread.sleep(1000);

		// interrupt
		inThread.interrupt();
		
		System.out.println("OK!");
	}
}

class InterrupThread implements Runnable {

	private int num = 1;

	@Override
	public void run() {
		while (true)
			try {
				Thread.sleep(10);
				System.out.println("true ----> " + num++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
}