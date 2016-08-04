package org.javacore.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <p>
 *	 <pre>
 * 		缓冲输入文件
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 13:54
 */
public class BufferedInputFileT {
	
	/**
	 * 通过文件名，读取文件并缓冲
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static String read(String filename) 
			throws IOException {
		// 通过行读取输入
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null)
			sb.append(s + "\n");// 不考了线程安全，StringBuilder 比  StringBuffer效率高
		// 关闭文件
		in.close();
		return sb.toString();
	}
	
	public static void main(String[] rags) throws IOException {
		// 缓冲输入文件，并打印
		System.out.println(read("/Users/Dev/github/java-core-learning-example/src/main/java/org/javacore/io/BufferedInputFileT.java"));
	}
}
