package org.javacore.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 * 
 * <pre>
 * 内存映射文件的使用
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 10:16
 */
public class LargeMappedFiles {

	static int length = 0x8FFFFFF; // 128 MB

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		String targetFile = "/Users/Dev/github/java-core-learning-example/src/main/resources/io/file/copy/channel/data3.txt";

		// 将此通道的文件区域直接映射到内存映射区域中。
		MappedByteBuffer out = new RandomAccessFile(targetFile, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE,
				0, length);

		// 写入128MB的字符串
		for (int i = 0; i < length; i++)
			out.put((byte) 'x');
		System.out.println("Finished writing");

		// 打印其中6个字符
		for (int i = length / 2; i < length / 2 + 6; i++)
			System.out.print((char) out.get(i));
		
	}
}
