/**
 * 
 */
package com.taomk.study.future;

/**
 * 
 * https://www.jianshu.com/p/6f537c9a6525
 * 
 * @author taomaokun
 *
 */
public class FutureData<D> {

	private boolean isReady = false;
	private D data;

	/**
	 * 一直阻塞，直到 <method>setData(D data)</method> 被执行
	 * 
	 * @return
	 */
	public synchronized D getData() {
		while (!isReady) {
			try {
				System.out.println("[" + Thread.currentThread().getName() + "@" + System.currentTimeMillis()
						+ "]try to get data...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(
				"[" + Thread.currentThread().getName() + "@" + System.currentTimeMillis() + "]get data finished.");
		return data;
	}

	public synchronized void setData(D data) {
		System.out.println(
				"[" + Thread.currentThread().getName() + "@" + System.currentTimeMillis() + "]set data finished.");
		this.data = data;
		isReady = true;
		notifyAll();
	}
}
