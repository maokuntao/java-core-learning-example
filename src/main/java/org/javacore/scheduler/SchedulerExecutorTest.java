package org.javacore.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 
 * <pre>
 * ScheduledExecutorService的使用1
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 14:29
 */
public class SchedulerExecutorTest implements Runnable {

	private final String jobName;

	public SchedulerExecutorTest(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public void run() {
		System.out.println("running => " + jobName);
	}

	public static void main(String[] args) {
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		// 一秒
		executor.scheduleAtFixedRate(new SchedulerExecutorTest("job1"), 1, 1, TimeUnit.SECONDS);
		// 两秒
		executor.scheduleWithFixedDelay(new SchedulerExecutorTest("job2"), 1, 2, TimeUnit.SECONDS);
	}
}
