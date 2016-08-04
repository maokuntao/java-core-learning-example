package org.javacore.io;

import java.io.IOException;
import java.io.StringReader;
/**
 * <p>
 * 
 * <pre>
 * 内存中输入
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 14:39
 */
public class MemoryInputT {
	public static void main(String[] args) throws IOException {
		StringReader in = new StringReader(BufferedInputFileT.read(
				"/Users/Dev/github/java-core-learning-example/src/main/java/org/javacore/io/MemoryInputT.java"));
		int c;
		while((c = in.read()) != -1)// int形式
			System.out.println((char)c);// int字节，转char显示
	}
}
