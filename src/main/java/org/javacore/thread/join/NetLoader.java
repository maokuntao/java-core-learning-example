package org.javacore.thread.join;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class NetLoader implements Runnable {
    @Override
    public void run() {
        System.out.println("begining the NetLoader");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("NetLoader has finished");
    }
}
