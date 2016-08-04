package org.javacore.thread;

import java.io.IOException;
import java.util.Scanner;

/**
 * <pre>
 * Java进程调用CMD
 * </pre>
 * 
 * VM options => -Dfile.encoding="GBK"
 * 
 * @author taomk
 * @since 2016-8-4
 */
public class ProcessBuilderTest {

	public static void main(String[] args) throws IOException {

		ProcessBuilder pb = new ProcessBuilder("ifconfig" , "-a");
		Process p = pb.start();

		Scanner scanner = new Scanner(p.getInputStream());
		
		while (scanner.hasNext())
			System.out.println(scanner.nextLine());
		
		scanner.close();
	}
}
