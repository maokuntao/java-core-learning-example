package org.javacore.thread;

/**
 * <pre>
 * Thread中start和run的区别
 * </pre>
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class SleepRunThread {

	public static void main(String[] args) {

		System.out.println("当前线程ID => " + Thread.currentThread().getId());

		SRThread t1 = new SRThread("t1");
		t1.start();// 真正启动了新的线程（不等于立即执行，只是新的线程处于就绪状态，需要等待CPU时间片才能执行，执行的内容是run方法里的逻辑）

		SRThread t2 = new SRThread("t2");
		t2.run();// 没有启动新的线程，还是主线程在运行，只是相当于对象的一个普通方法
	}
}

class SRThread extends Thread {

	private String name;

	public SRThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("name:" + name + ", 线程ID => " + Thread.currentThread().getId());
	}
}