package org.javacore.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * <p>
 * 
 * <pre>
 * ByteBuffer与char之间转换
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 15:56
 */
public class BufferToText {
	
    private static final int BSIZE = 1024; // 1K 字节
    
    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
    	
        // 从文件输出流获取FileChannel
        FileChannel fc =
                new FileOutputStream("data.txt").getChannel();
        // 将带有字节的缓冲区写入该通道
        fc.write(ByteBuffer.wrap("some data".getBytes()));
        fc.close();

        // 从文件输入流中获取FileChannel
        fc = new FileInputStream("data.txt").getChannel();
        // 分配ByteBuffer的大小 1K
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        // 将字节序列通过此通道写入到buffer
        fc.read(buffer);
        // 反转缓冲区，为写或者读取做准备
        buffer.flip();
        // 作为char缓冲区，并输出 乱码，因为Buffer编码是"UTF-16BE"
        System.out.println(buffer.asCharBuffer());

        // 重绕此缓冲区
        buffer.rewind();
        // 获取文件编码属性
        String encoding = System.getProperty("file.encoding");
        // 输出编码及内容
        System.out.println("编码： " + encoding + " 内容为： "
                + Charset.forName(encoding).decode(buffer));
        fc.close();

        // 从文件输出流获取FileChannel
        fc = new FileOutputStream("data.txt").getChannel();
        // 将带有字节的缓冲区写入该通道
        fc.write(ByteBuffer.wrap("some data".getBytes("UTF-16BE")));
        fc.close();

        // 从文件输入流中获取FileChannel
        fc = new FileInputStream("data.txt").getChannel();
        // 清除其缓冲区
        buffer.clear();
        // 将字节序列通过该通道写入到buffer
        fc.read(buffer);
        // 反转缓冲区，为写或者读取做准备
        buffer.flip();
        // 作为char缓冲区，并输出
        System.out.println(buffer.asCharBuffer());
        fc.close();

        // 从文件输出流获取FileChannel
        fc = new FileOutputStream("data.txt").getChannel();
        // 指定buffer大小为 24字节
        buffer = ByteBuffer.allocate(24);
        // 通过char缓冲区，在当前位置写入字符
        buffer.asCharBuffer().put("some data");
        // 将带有字节的缓冲区写入该通道
        fc.write(buffer);
        fc.close();

        // 从文件输入流中获取FileChannel
        fc = new FileInputStream("data.txt").getChannel();
        // 清除缓冲区
        buffer.clear();
        // 将字节序列通过文件通道写入到buffer
        fc.read(buffer);
        // 反转缓冲区，为读或者写做准备
        buffer.flip();
        // 作为char缓冲区，并输出
        System.out.println(buffer.asCharBuffer());
    }
}
