package org.javacore.scheduler;

import java.util.Timer;
import java.util.TimerTask;

/**
 * <p>
 * 
 * <pre>
 * Timer的使用
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 14:36
 */
public class TimerTest extends TimerTask{

    private final String jobName;

    public TimerTest(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println("run the task => " + jobName);
    }

    public static void main(String[] args) {
        // 一种工具，线程用其安排以后在后台线程中执行的任务
        Timer timer = new Timer();
        timer.schedule(new TimerTest("Job 1") , 1000 , 1000); // 一秒
        timer.schedule(new TimerTest("Job 2") , 2000 , 2000); // 两秒
    }
}
