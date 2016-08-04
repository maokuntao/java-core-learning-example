package org.javacore.thread.daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * 写事件到一个队列
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class WriterTask implements Runnable {

	private Deque<Event> deque;

	public WriterTask(Deque<Event> deque) {
		this.deque = deque;
	}

	// 添加10个事件
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent(String.format("The thread  %s has generated an event .", Thread.currentThread().getId()));
			deque.addFirst(event);
			System.out.printf("The thread  %s has generated an event .\n", event.getEvent());
			
			try {
				// 间隔1秒
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
