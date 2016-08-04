package org.javacore.thread.join;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class DSLoader implements Runnable {
	
    @Override
    public void run() {
        System.out.println("begining the DSLoader");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DSLoader has finished");
    }
}
