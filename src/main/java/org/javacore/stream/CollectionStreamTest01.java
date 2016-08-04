package org.javacore.stream;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 
 * <pre>
 * Stream API 集合的流式操作
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 16:20
 */
public class CollectionStreamTest01 {
	
    public static void main(String[] args) {
    	
        List<String> strList = Arrays.asList("a1", "a2", "c3", "c6", "c4");

        strList
                .stream() // 获取Stream
                .filter(str -> str.startsWith("c"))// 过滤－选取以"c"打头的字符串
                .map(String::toUpperCase)// 将字符串转换为大写(包含遍历)
                .sorted()// 排序
                .forEach(System.out::println);// 遍历输出
    }
}
