package org.javacore.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>
 * 
 * <pre>
 * 操作系统进程流
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 14:43
 */
public class OSExecuteT {

	public static void commond(String... command) {

		try {
			// 创建操作系统进程
			Process process = new ProcessBuilder(command).start();

			// 读取进程的输入流
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while ((s = results.readLine()) != null)
				System.out.println(s);

			// 读取进程的错误流
			BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while ((s = errors.readLine()) != null) {
				System.err.println(s);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static void main(String[] args) {
		// commond("java" , "-version");
		commond("ifconfig");
	}
}

class OSExecuteException extends RuntimeException {
	private static final long serialVersionUID = -3254218368058055219L;

	public OSExecuteException(String msg) {
		super(msg);
	}
}
