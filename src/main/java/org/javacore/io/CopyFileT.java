package org.javacore.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>
 *	 <pre>
 * 		文件复制
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 13:58
 */
public class CopyFileT {
	public static void main(String[] args) throws IOException {
		String dir = "/Users/Dev/github/java-core-learning-example/src/main/resources/io/file/copy";
		
		copyFile(dir + File.separator + "/金山岭秋色.jpg", dir + File.separator + "/copy file.jpg");
		
		System.out.println("OK!");
	}
	
	public static void copyFile(String srcFile,String destFile) 
		throws IOException {
		copyFile(new File(srcFile), new File(destFile));
	}
	
	public static void copyFile(File srcFile,File destFile)
		throws IOException {
		// 文件不存在
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件：" + srcFile + "不存在");
		}
		// 文件不是文件类型
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] bytes = new byte[2 * 1024];
		int b;
		while ((b=in.read(bytes, 0, bytes.length)) != -1) {
			out.write(bytes, 0, b);
			out.flush();
		}
		out.close();
		in.close();
	}
}