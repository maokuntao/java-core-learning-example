package org.javacore.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 
 * <pre>
 * 文件加锁
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 10:05
 */
public class FileLocking {

	public static void main(String[] args) throws IOException, InterruptedException {
		// 获取输出流
		FileOutputStream fos = new FileOutputStream(
				"/Users/Dev/github/java-core-learning-example/src/main/resources/io/file/copy/channel/data.txt");
		// 从输出流中获取文件加锁对象，并锁定File
		FileLock fl = fos.getChannel().lock();
		if (fl != null) {
			System.out.println("Locked File");
			TimeUnit.MICROSECONDS.sleep(100);
			// 释放文件锁定
			fl.release();
			System.out.println("Release Lock");
		}
		fos.close();
	}
}
