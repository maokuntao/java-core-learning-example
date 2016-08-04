package org.javacore.thread.uncaughtexp;

/**
 * 实现异常类Test
 * @author taomk
 * @since 2016-8-4
 */
public class UncaughtTest {

	public static void main(String[] args) {

		UncaughtTask uncaughtTask = new UncaughtTask();
		Thread thread = new Thread(uncaughtTask);
		thread.setUncaughtExceptionHandler(new ExceptionHadler());

		// 执行业务方法，抛出异常
		thread.start();
	}
}
