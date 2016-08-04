package org.javacore.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 * 
 * <pre>
 * FileChannel读写文件案例
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 9:58
 */
public class FileChannelT {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		// 源文件路径
		String dir = "/Users/Dev/github/java-core-learning-example/src/main/java/org/javacore/nio/FileChannelT.java";

		// 目标路径
		String destFilePaht = "/Users/Dev/github/java-core-learning-example/src/main/resources/io/file/copy/channel";

		// 获取FileChannelT.java文件，读写方式
		RandomAccessFile inFile = new RandomAccessFile(dir, "rw");
		
		// 创建输出文件流
		FileOutputStream outFileStream = new FileOutputStream(destFilePaht + "/FileChannelT.java");
		
		// 创建输入文件通道
		FileChannel inChannel = inFile.getChannel();
		
		// 创建输出文件通道
		FileChannel outChannel = outFileStream.getChannel();
		
		// 分配一个1024字节的字节缓存区
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024); // 比allocate();效率高

		// 测试时间
		long startTime = System.currentTimeMillis();

		// 读文件，存文件
		while (true) {
			// 将字节序列从此通道读入给定的缓冲区
			int eof = inChannel.read(byteBuffer);
			// 读到文件末尾退出
			if (eof == -1)
				break;
			// 反转缓冲区
			byteBuffer.flip();
			// 将字节序列从给定的缓冲区写入此通道
			outChannel.write(byteBuffer);
			// 清空缓存区
			byteBuffer.clear();
		}
		inChannel.close();
		outChannel.close();

		System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
	}

}
