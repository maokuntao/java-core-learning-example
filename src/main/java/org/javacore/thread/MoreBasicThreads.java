package org.javacore.thread;

/**
 * <pre>
 * 线程简单使用<br>启动多个LiftOff线程{@link LiftOff}
 * </pre>
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class MoreBasicThreads {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++)
			new Thread(new LiftOff()).start();
		
		System.out.println("Waiting for LiftOff");
	}
}
