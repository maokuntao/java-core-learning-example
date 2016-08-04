package org.javacore.thread;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 后台线程遇到Finally
 * </pre>
 * 
 * @author taomk
 * @since 2016-8-4
 */
class ADaemon implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("启动ADaemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		} finally {
			// 因为main是非后台线程，main线程结束。ADaemon后台线程也就结束。因此可能没到finally就结束了。
			System.out.println("finally 运行吗？");
		}
	}
}

public class DaemonsDontRunFinally {

	public static void main(String[] args) {

		Thread t = new Thread(new ADaemon());
		// 设置线程为后台线程
		t.setDaemon(true);
		t.start();
	}
}
