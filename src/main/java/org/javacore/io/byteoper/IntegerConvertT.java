package org.javacore.io.byteoper;

/**
 * <p>
 *	 <pre>
 * 		int与byte数组转换
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 10:04
 */
public class IntegerConvertT {
	
	public static void main(String[] args){
		// 将学号转换成字节码
		byte[] bytes = int2Bytes(1206010035);
		System.out.println(bytes[0] + " " + bytes[1] + " " + bytes[2] + " " + bytes[3]);
		// 字节码就可以转换回学号
		System.out.println(IntegerConvertT.bytes2Int(bytes));
	}
	
	/**
	 * Int转字节数组
	 */
	public static byte[] int2Bytes(int inta){
		// 32位Int可存于长度为4的字节数组 
		byte[] bytes = new byte[4];
		for (int i = 0; i < bytes.length; i++)
			bytes[i] = (byte)(int)((inta >> i * 8) & 0xff);// 移位和清零
		
		return bytes;
	}
	
	/**
	 * 字节数组转Int
	 */
	public static int bytes2Int(byte[] bytes){
		int inta = 0;
		for (int i = 0; i < bytes.length; i++)
			inta += (int)((bytes[i] & 0xff) << i * 8);// 移位和清零
		
		return inta;
	}
	
}
