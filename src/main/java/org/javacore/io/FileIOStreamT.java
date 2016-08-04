package org.javacore.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>
 *	 <pre>
 * 		FileInputStream&FileOutputStream的简单使用
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 14:14
 */
public class FileIOStreamT {
	private static final String thisFilePath = 
			"/Users/Dev/github/java-core-learning-example/src/main/java/org/javacore/io/FileIOStreamT.java";
	
	private static final String thisFileOutputPath = 
			"/Users/Dev/github/java-core-learning-example/src/main/resources/io/iostream/" ;
	
	public static void main(String[] args) throws IOException {
		// 创建文件输入流
		FileInputStream fileInputStream = new FileInputStream(thisFilePath);
		// 创建文件输出流
		FileOutputStream fileOutputStream =  new FileOutputStream(thisFileOutputPath + "FileIOStreamT.txt");
		
		// 创建流的最大字节数组
		byte[] inOutBytes = new byte[fileInputStream.available()];
		// 将文件输入流读取，保存至inOutBytes数组
		fileInputStream.read(inOutBytes);
		// 将inOutBytes数组，写出到data.txt文件中
		fileOutputStream.write(inOutBytes);
		
		fileOutputStream.close();
		fileInputStream.close();
		
		System.out.println("OK!");
	}
}
