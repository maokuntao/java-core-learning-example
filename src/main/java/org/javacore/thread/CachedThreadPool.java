package org.javacore.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池CachedThreadPool的简单使用-启动LiftOff线程<br>
 * {@link LiftOff}
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class CachedThreadPool {

	public static void main(String[] args) {

		// 创建新线程的线程池
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 5; i++)
			// 由线程池Ececutor决定执行给定的线程。
			exec.execute(new LiftOff()); 

		// 顺序关闭，执行以前提交的线程，不接受新的线程。
		exec.shutdown();
	}
}
