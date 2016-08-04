package org.javacore.io;

import java.io.PrintWriter;
/**
 * <p>
 *	 <pre>
 * 		改变System.out输出
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 13:57
 */
public class ChangeSystemOut {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		out.println("Hello PrintWriter");
		out.close();
	}
}
