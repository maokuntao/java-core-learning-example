package org.javacore.thread;

import java.util.concurrent.ThreadFactory;

/**
 * <pre>
 * 线程工厂类
 * </pre>
 * 将线程设置为后台线程
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        System.out.printf("The thread id is : %s . \n" , t.getId());
        return t;
    }
}
