package org.javacore.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 休眠线程sleep的使用
 * </pre>
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class SleepingTask extends LiftOff {

	@Override
	public void run() {
		while (countDown-- > 0) {
			try {
				System.out.println(status());
				// 老版本调用：Thread.sleep(1000);
				TimeUnit.MICROSECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		// 创建新的线程池
		ExecutorService exec = Executors.newCachedThreadPool();

		for (int i = 0; i < 5; i++)
			exec.execute(new SleepingTask());// 由线程池决定执行线程

		// 顺序关闭，执行以前提交的线程，不接受新的线程
		exec.shutdown();
	}
}
