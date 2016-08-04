package org.javacore.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * <p>
 * 
 * <pre>
 * 格式化内存输入
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 14:37
 */
public class FormatteMemoryInput {
	public static void main(String[] args) throws IOException {
		String filePath = "/Users/Dev/github/java-core-learning-example/src/main/java/org/javacore/io/FormatteMemoryInput.java";
		try {
			DataInputStream in = new DataInputStream(
					// 缓冲区字节输入
					new ByteArrayInputStream(BufferedInputFileT.read(filePath).getBytes()));
			while (true)
				System.out.println((char) in.readByte());
		} catch (EOFException e) {
			System.out.println("End of Stream");
		}
	}
}
