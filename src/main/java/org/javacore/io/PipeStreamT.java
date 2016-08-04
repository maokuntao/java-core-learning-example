package org.javacore.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * <p>
 * 
 * <pre>
 * 管道输入输出流的使用
 * </pre>
 * 
 * 同一个JVM中，两个线程直接的字节流通信
 * 
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 15:07
 */
public class PipeStreamT {

	public static void main(String[] args) throws IOException {

		// 创建管道输出流
		final PipedOutputStream output = new PipedOutputStream();

		// 创建管道输入流，并连接到管道输出流
		@SuppressWarnings("resource")
		final PipedInputStream input = new PipedInputStream(output);

		// 等价于
		// final PipedInputStream input = new PipedInputStream();
		// input.connect(output);

		// 信息输出线程
		Thread outputThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 将指定的字节数组写入管道输出流
					output.write("Hello,PipedStream!".getBytes());
				} catch (IOException e) {
				}
			}
		});

		// 信息获取线程
		Thread inputThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("inputThread received message successfully!");
					// 读取管道输入流中的下一个数据字节
					int data = input.read();
					while (data != -1) {
						System.out.print((char) data);
						// 再次读取下一个字节
						data = input.read();
					}
				} catch (IOException e) {
				}
			}
		});

		outputThread.start();
		inputThread.start();
	}
}
