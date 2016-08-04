package org.javacore.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * 线程池FixedThreadPool的简单使用<br>启动LiftOff线程{@link LiftOff}
 * </pre>
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class FixedThreadPool {

	public static void main(String[] args) {

		// 创建固定线程为5的线程池
		ExecutorService exec = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());// 由线程池Ececutor决定执行给定的线程。
		
		// 顺序关闭，执行以前提交的线程，不接受新的线程。
		exec.shutdown();
	}
}
