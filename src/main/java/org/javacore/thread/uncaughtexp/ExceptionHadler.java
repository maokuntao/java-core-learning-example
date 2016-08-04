package org.javacore.thread.uncaughtexp;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 处理运行时异常的类
 * @author taomk
 * @since 2016-8-4
 */
public class ExceptionHadler implements UncaughtExceptionHandler{
	
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been captured\n");
        System.out.printf("Thread: %s\n",t.getId());
        System.out.printf("Exception: %s: %s\n",e.getClass().getName(),e.getMessage());
        System.out.printf("Stack Trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n",t.getState());
    }
}
