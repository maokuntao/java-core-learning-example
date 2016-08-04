package org.javacore.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>
 * 
 * <pre>
 * DataOutputStream和DataInputStream的使用
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 15:23
 */
public class StoringAndRecoveringData {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		String filePath = "/Users/Dev/github/java-core-learning-example/src/main/resources/io/file/data.file";
		
		// 写入数据
		DataOutputStream outputStream = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(filePath)));
		outputStream.writeDouble(3.1415926);
		outputStream.writeUTF("你好");
		outputStream.writeInt(1);
		outputStream.close();
		
		// 写出数据
		DataInputStream inputStream = new DataInputStream(
				new BufferedInputStream(new FileInputStream(filePath)));
		System.out.println(inputStream.readDouble());
		System.out.println(inputStream.readUTF());
		System.out.println(inputStream.readInt());
	}
}
