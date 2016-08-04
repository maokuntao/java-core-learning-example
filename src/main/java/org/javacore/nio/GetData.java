package org.javacore.nio;

import java.nio.ByteBuffer;

/**
 * <p>
 * 
 * <pre>
 * ByteBuffer操作类型数据
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 10:11
 */
public class GetData {
	
    private static final int BSIZE = 1024; // 1K字节
    
    public static void main(String[] args) {
        // 创建字节缓冲区
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < bb.limit())// 缓冲区的限制
            if (bb.get() != 0)// 读取当前位置字节，如果字节不等于0
                System.out.println("该字节不为0");
        // 读取到最后一个跳出限制while，i为BSIZE大1。
        System.out.println("i = " + i);

        // 重绕此缓冲区
        bb.rewind();
        // 写入Hello
        bb.asCharBuffer().put("Hello");
        // 从缓冲区读取char，并输出
        char c;
        while ((c = bb.getChar()) != 0)
            System.out.print(c + " ");
        System.out.println();

        // 写入Short类型数据
        bb.asShortBuffer().put((short) 47142);
        System.out.println(bb.getShort());
        // 重绕此缓冲区
        bb.rewind();

        // 写入Long类型数据
        bb.asLongBuffer().put((long)99471142);
        System.out.println(bb.getLong());
        // 重绕此缓冲区
        bb.rewind();
    }
}
