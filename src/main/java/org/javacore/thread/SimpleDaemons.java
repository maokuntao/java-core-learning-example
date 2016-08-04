package org.javacore.thread;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Daemon后台线程的简单使用
 * </pre>
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class SimpleDaemons implements Runnable {

	@Override
	public void run() {
		try {
			while (true) {
				TimeUnit.MICROSECONDS.sleep(1000);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			System.out.println("sleep() interrupted");
		}
	}

	// main是非后台线程
	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 10; i++) {
			// 创建一个新线程
			Thread daemon = new Thread(new SimpleDaemons());
			// 设置为后台线程
			daemon.setDaemon(true);
			daemon.start();
		}
		
		System.out.println("所有任务已启动");
		
		// 如果main结束，那么同时会杀死所有后台线程,多次运行你会发现，可能打印的后台线程数不定
		TimeUnit.MICROSECONDS.sleep(175);
	}
}
