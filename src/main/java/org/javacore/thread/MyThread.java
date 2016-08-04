package org.javacore.thread;

/**
 * <pre>
 * 	Thread的简单使用<br>
 * </pre>
 * 	测试 --> {@link MyThreadTest}
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class MyThread extends Thread{

	@Override
	public void run() {
		System.out.println("MyThread --> run()");
	}

}
