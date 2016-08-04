package org.javacore.io.zip;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * <p>
 *	 <pre>
 * 		GZIP简单使用
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 11:27
 */
public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        // 用Reader读文件
        BufferedReader in = new BufferedReader(new  InputStreamReader(
                new  FileInputStream("data.gz" ),  "UTF-8" ));
        // 使用缓冲输出流，输出压缩流文件
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(new FileOutputStream("data.gz")));
        System.out.println("Writing File 压缩");
        int c;
        while ((c = in.read()) > 0)
            out.write(String.valueOf((char)c).getBytes("UTF-8"));
        in.close();
        out.close();

        System.out.println("Reading File 解压");
        // 用输入解压流读取文件
        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(
                        new GZIPInputStream(new FileInputStream("data.gz")),"UTF-8"));// encoding question
        String s;
        while ((s=in2.readLine()) != null)
            System.out.println(s);
        in2.close();
    }
}
