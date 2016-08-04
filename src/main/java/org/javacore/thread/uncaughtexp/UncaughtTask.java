package org.javacore.thread.uncaughtexp;

/**
 * 抛出运行时异常的线程类
 * @author taomk
 * @since 2016-8-4
 */
public class UncaughtTask implements Runnable {

	@Override
    public void run() {
        Integer.parseInt("TTTT");
    }
}
