package org.javacore.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * <p>
 * 
 * <pre>
 * ByteBuffer中字节存储次序
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 9:55
 */
public class Endians {
    public static void main(String[] args) {
        // 创建12个字节的字节缓冲区
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        // 存入字符串
        bb.asCharBuffer().put("abdcef");
        System.out.println(Arrays.toString(bb.array()));

        // 反转缓冲区
        bb.rewind();
        // 设置字节存储次序
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        // 反转缓冲区
        bb.rewind();
        // 设置字节存储次序
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
    }
}
