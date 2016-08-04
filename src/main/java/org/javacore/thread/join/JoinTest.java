package org.javacore.thread.join;

/**
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class JoinTest {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new DSLoader());
		Thread t2 = new Thread(new NetLoader());

		t1.start();
		t2.start();

		// 可以注释其中一个加深理解
		 t1.join();
		 t2.join();

		System.out.println("ending all");
	}
}
