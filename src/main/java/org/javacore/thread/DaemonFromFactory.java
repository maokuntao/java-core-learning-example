package org.javacore.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 后台线程工厂类的使用
 * </pre>
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class DaemonFromFactory implements Runnable {
    
	@Override
    public void run() {
        try {
            while (true){
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
    	
        // 使用提供的线程工厂类，创建线程池
        ExecutorService exec =
                Executors.newCachedThreadPool(new DaemonThreadFactory());
    
        for (int i = 0 ; i < 10 ; i++)
            exec.execute(new DaemonFromFactory());// 此Runnable实现类，经过线程工厂创建
        
        // 关闭线程池
        exec.shutdown();
        System.out.println("任务已经全部启动");
        TimeUnit.MICROSECONDS.sleep(500);
    }

}
