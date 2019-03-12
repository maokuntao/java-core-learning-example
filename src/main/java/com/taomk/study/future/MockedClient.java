/**
 * 
 */
package com.taomk.study.future;

/**
 * mocked client
 * 
 * <br>
 * 通过FutureData将两个串行耗时操作(5s + 3s)处理之后变成5s
 * 
 * @author taomaokun
 *
 */
public class MockedClient {

	public static void main(String[] args) throws InterruptedException {

		MockedServer server = new MockedServer();

		System.out.println(
				"[" + Thread.currentThread().getName() + "@" + System.currentTimeMillis() + "]Client request start...");
		FutureData<String> response = server.process();

		// 其他操作
		Thread.sleep(5 * 1000);

		System.out.println("[" + Thread.currentThread().getName() + "@" + System.currentTimeMillis()
				+ "]Client getData:" + response.getData());

		System.exit(1);
	}
}
