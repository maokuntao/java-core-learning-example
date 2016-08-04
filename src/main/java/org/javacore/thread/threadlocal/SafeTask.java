package org.javacore.thread.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal对象(线程局部变量)不会被所有线程共享
 * @author taomk
 * @since 2016-8-4
 */
public class SafeTask implements Runnable{
    /**
     * ThreadLocal对象不会被所有线程共享
     * --> 线程局部变量 <--
     */
    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        /**
         * 隐式实现初始化对象
         * @return
         */
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread:%s : %s\n",Thread.currentThread().getId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Finish Thread:%s : %s\n",Thread.currentThread().getId(),startDate.get());
    }
}
