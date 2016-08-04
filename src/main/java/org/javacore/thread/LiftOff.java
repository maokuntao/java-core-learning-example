package org.javacore.thread;

/**
 * 实现Runnable接口的类
 * @author taomk
 * @since 2016-8-4
 */
public class LiftOff implements Runnable{

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + "(" +
                (countDown >0 ? countDown : "LiftOff!") + "), ";
    }
    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
            // 暂停当前正在执行线程，并执行其他线程。
            Thread.yield();
        }
    }
}
