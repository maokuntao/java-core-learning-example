package org.javacore.stream;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 
 * <pre>
 * 排序
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-4 9:27
 */
public class SortedStreamTest {
	
    public static void main(String[] args) {
    	
        List<String> list1 = Arrays.asList("a","e","b","ac");
        // 排序
        list1.stream().sorted().forEach(str -> System.out.print(str + " -> "));
    }
}
