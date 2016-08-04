package org.javacore.thread;

/**
 * <pre>
 * 	Runnable接口的简单使用<br>
 * </pre>
 * 	测试 --> {@link MyRunnableTest}
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("MyRunnable --> run()");
	}

}
