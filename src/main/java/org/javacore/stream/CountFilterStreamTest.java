package org.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 
 * <pre>
 * 过滤 - 流的元素数量
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 16:57
 */
public class CountFilterStreamTest {
	
    public static void main(String[] args) {
    	
        List<String> list1 = Arrays.asList("a","b","ac");

        // filter 过滤
        List<?> result = list1.stream().filter(str -> str.startsWith("a")).collect(Collectors.toList());
        result.stream().forEach(System.out::println);
        System.out.println();

        // count  流的元素数量
        long l = list1.stream().filter(str -> str.startsWith("a")).count();
        System.out.println("list1中元素从a开始的数量:" + l);

    }
}
