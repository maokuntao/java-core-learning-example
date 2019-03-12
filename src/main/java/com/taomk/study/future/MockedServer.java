/**
 * 
 */
package com.taomk.study.future;

import java.util.concurrent.Executors;

/**
 * mocked server
 * 
 * @author taomaokun
 *
 */
public class MockedServer {

	/**
	 * server端业务方法，立即响应client的请求
	 * 
	 * @return
	 */
	public FutureData<String> process() {
		System.out.println("["  + Thread.currentThread().getName()+"@" + System.currentTimeMillis() + "]Server process start...");
		FutureData<String> response = new FutureData<String>();
		Executors.newSingleThreadExecutor().execute(new Runnable() {

			@Override
			public void run() {
				try {
					// 模拟server端业务处理耗时
					Thread.sleep(3 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				
				response.setData("I'm READY.");
			}

		});
		System.out.println("[" + Thread.currentThread().getName()+"@" + System.currentTimeMillis() + "]Server process finished.");
		return response;
	}
}
