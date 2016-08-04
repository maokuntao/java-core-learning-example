package org.javacore.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * <p>
 * 
 * <pre>
 * 通过IntBuffer操作ByteBuffer的int型数据
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 10:14
 */
public class IntBufferDemo {
	
    private static final int BSIZE = 1024;// 1K字节
    
    public static void main(String[] args) {
    	
        // 创建1字节大小的字节缓冲区
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // int视图缓冲区
        IntBuffer ib = bb.asIntBuffer();
        // 存储一个数组
        ib.put(new int[]{1, 2, 3, 4, 5, 6});
        // 通过访问ByteBuff字节缓冲区，获取某个位置的值
        System.out.println(ib.get(3));
        // 存储一个int数据
        ib.put(3, 44);
        // 反转缓冲区
        ib.flip();
        // 如果当前位置还有元素
        while (ib.hasRemaining()) {
            // 获取当前位置的元素
            int i = ib.get();
            System.out.println(i);
        }
    }
}
