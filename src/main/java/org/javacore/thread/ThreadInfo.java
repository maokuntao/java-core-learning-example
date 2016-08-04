package org.javacore.thread;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <pre>
 * 线程优先级案例
 * </pre>
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class ThreadInfo {

	public static void main(String[] args) {

		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];

		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator(i));
			if ((i % 2) == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			// threads[i].setName("");
		}

		PrintWriter pw = null;
		try {
			// 将线程的信息写入info文件
			FileWriter fw = new FileWriter(
					"/Users/Dev/github/java-core-learning-example/src/main/resources/threadinfo/threadinfo.info");
			
			pw = new PrintWriter(fw);

			for (int i = 0; i < 10; i++) {
				pw.println("Main: Status of Thread " + i + " : " + threads[i].getState());
				status[i] = threads[i].getState();
			}

			// 启动线程
			for (int i = 0; i < 10; i++)
				threads[i].start();

			boolean finish = false;
			while (!finish) {
				for (int i = 0; i < 10; i++) {
					if (threads[i].getState() != status[i]) {
						writeThreadInfo(pw, threads[i], status[i]);
						status[i] = threads[i].getState();
					}
				}
				finish = true;
				for (int i = 0; i < 10; i++) {
					finish = finish && (threads[i].getState() == Thread.State.TERMINATED);// 中断
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.flush();
			pw.close();
		}
		
		System.out.println("OK!");
	}

	private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State status) {
		pw.printf("Main: Id %d - $s\n", thread.getId(), thread.getName());
		pw.printf("Main: Priority: %d\n", thread.getPriority());
		pw.printf("Main: OldState: %s\n", status);
		pw.printf("Main: New State: %s\n", thread.getState());
		pw.printf("*****************************************\n");
	}
}

class Calculator implements Runnable {

	private int number;

	public Calculator(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
		}
	}
}
