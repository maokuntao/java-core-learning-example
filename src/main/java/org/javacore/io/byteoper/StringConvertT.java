package org.javacore.io.byteoper;
/**
 * <p>
 *	 <pre>
 * 		String转换成byte数组
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 11:03
 */
public class StringConvertT {

	public static void main(String[] args){
		String str = "李强强";
		byte[] bytes = str.getBytes();
		// 打印字节数组
		System.out.printf("UTF-8编码'%s'的字节数组为：\n" , str);
		for (int i = 0; i < bytes.length; i++)
			System.out.print("\t" + bytes[i]);
	}
}
