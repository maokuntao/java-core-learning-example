package org.javacore.thread;

/**
 * 线程简单使用-启动LiftOff线程<br>{@link LiftOff}
 * @author taomk
 * @since 2016-8-4
 */
public class BasicThreads {
	
    public static void main(String[] args) {
        
    	// 创建新的线程
        Thread t = new Thread(new LiftOff());
        
        // 执行线程
        t.start();
        
        System.out.println("Waiting for LiftOff");
    }
}
