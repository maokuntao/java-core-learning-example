package org.javacore.lambda;

/**
 * <p>
 * 
 * <pre>
 * Lambda 启动线程
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 15:54
 */
public class LambdaRunnable {

	static int b = 10;

	public static void main(String[] args) {
		
		// 传统风格－启动线程
		// Thread thread = new Thread(new Runnable() {
		// @Override
		// public void run() {
		// b++;
		// System.out.println(b);
		// }
		// });

		// Lambda - 启动线程
		Thread thread = new Thread(() -> {
			b++;
			System.out.println(b);
		});
		
		thread.start();
		
		System.out.println("Done!");
	}
}
