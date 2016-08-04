package org.javacore.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * <p>
 * 
 * <pre>
 * FileChannel的文件复制案例
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 16:38
 */
public class ChannelCopy {
	// 读取的文件
	private static final String sourceFile = 
			"/Users/Dev/github/java-core-learning-example/src/main/java/org/javacore/nio/ChannelCopy.java";
	// 输出的文件
	private static final String targetFile = "/Users/Dev/github/java-core-learning-example/src/main/resources/io/file/copy/channel/data.txt";
	
	private static final int BSIZE = 1024; // 1K字节
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 创建用于读写的Channel
		FileChannel 
			in  = new FileInputStream(sourceFile).getChannel(),
			out = new FileOutputStream(targetFile).getChannel();
		
		// 分配ByteBuffer的大小 1K
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		// 将字节序列从此通道读入给定的缓冲区,分块读，直至读到文件末端
		while (in.read(buffer) != -1) {// -1,表示读到文件末端
			// 反转缓冲区，为写入或读取做好准备
			buffer.flip();
			// 将含有字节序列的缓冲区写入文件通道
			out.write(buffer);
			// 清空缓冲区
			buffer.clear();
		}
		
		System.out.println("OK!");
	}
}
