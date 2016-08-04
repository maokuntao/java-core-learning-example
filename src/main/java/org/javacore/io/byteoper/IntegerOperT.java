package org.javacore.io.byteoper;
/**
 * <p>
 *	 <pre>
 * 		Integer类的进制转换
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 11:00
 */
public class IntegerOperT {

	public static void main(String[] args) {
		System.out.println("17的十六进制 : \t" + Integer.toHexString(17));
		System.out.println("17的八进制 : \t" 	+ Integer.toOctalString(17));
		System.out.println("17的二进制 : \t" 	+ Integer.toBinaryString(17));

		System.out.println(Integer.valueOf("11", 16));
		System.out.println(Integer.valueOf("21", 8));
		System.out.println(Integer.valueOf("00010001", 2));
	}

}
