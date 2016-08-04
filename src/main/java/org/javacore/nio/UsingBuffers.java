package org.javacore.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * <p>
 * 
 * <pre>
 * 利用buffer实现交换相邻字符
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 10:43
 */
public class UsingBuffers {

    private static void symmetricScaramble(CharBuffer buffer) {
    	
        while (buffer.hasRemaining()) {
            // 将mark设为position
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            // 重置为以前标记的位置
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        // 一个字符两个字节
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        
        // 重绕此缓冲区
        System.out.println(cb.rewind());
        
        symmetricScaramble(cb);
        // 重绕此缓冲区
        System.out.println(cb.rewind());
        
        symmetricScaramble(cb);
        System.out.println(cb.rewind());
    }
}
