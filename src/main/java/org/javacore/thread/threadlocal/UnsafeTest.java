package org.javacore.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * 可以看到线程每个有不同的启动时间，但是结束时间会有相同。
 * @author taomk
 * @since 2016-8-4
 */
public class UnsafeTest {
	
    public static void main(String[] args) {
    	
        UnsafeTask task = new UnsafeTask();
        
        for (int i = 0 ; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
