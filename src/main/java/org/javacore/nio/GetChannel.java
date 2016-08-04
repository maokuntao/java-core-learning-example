package org.javacore.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 * 
 * <pre>
 * 从流中获取FileChannel的案例
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 10:05
 */
public class GetChannel {
	
	private static final int BSIZE = 1024; // 1K字节
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		// 操作文件对象
		String targetFile = "/Users/Dev/github/java-core-learning-example/src/main/resources/io/file/copy/channel/data2.txt";
		
		// 写入文件
		
		// 从文件输出流获取FileChannel
		FileChannel fc = new FileOutputStream(targetFile).getChannel();
		// 将含有字节序列的缓冲区写入文件通道
		fc.write(ByteBuffer.wrap("Some Text".getBytes()));// 将已存在的字节数组包装到ByteBuffer
		// 关闭通道
		fc.close();
		
		// 从文件尾部写入

		// 从RandomAccessFile获取FileChannel文件
		fc = new RandomAccessFile(targetFile, "rw").getChannel();
		// 文件指针指向文件尾部
		fc.position(fc.size());
		// 将含有字节序列的缓冲区写入文件通道
		fc.write(ByteBuffer.wrap(" Some more".getBytes()));
		// 关闭通道
		fc.close();
		
		// 读取文件

		// 从文件输出流获取FileChannel文件
		fc = new FileInputStream(targetFile).getChannel();
		// 分配ByteBuffer的大小 1K
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		// 将字节序列从此通道读入给定的缓冲区。
		fc.read(buffer);
		// 反转缓冲区，为写入或读取做好准备
		buffer.flip();
		// 打印
		while (buffer.hasRemaining()) {
			System.out.print((char)buffer.get());
		}
	}
	
}
