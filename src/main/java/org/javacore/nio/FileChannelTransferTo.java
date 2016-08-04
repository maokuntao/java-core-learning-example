package org.javacore.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * <p>
 * 
 * <pre>
 * FileChannel的transferTo / transferFrom案例
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 10:02
 */
public class FileChannelTransferTo {
	// 读取的文件
	private static final String sourceFile = "/Users/Dev/github/java-core-learning-example/src/main/java/org/javacore/nio/FileChannelTransferTo.java";
	// 输出的文件
	private static final String targetFile = "/Users/Dev/github/java-core-learning-example/src/main/resources/io/file/copy/channel/FileChannelTransferTo.java";

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 创建用于读写的Channel
		FileChannel in = new FileInputStream(sourceFile).getChannel(),
				out = new FileOutputStream(targetFile).getChannel();
		// 将in通道的字节传输给out可写入字节通道
		in.transferTo(0, in.size(), out);
		// or
		// 将字节从给定的可读取字节通道传输到此通道的文件中。
		// out.transferFrom(in, 0, in.size());
		
		System.out.println("OK!");
	}
}
