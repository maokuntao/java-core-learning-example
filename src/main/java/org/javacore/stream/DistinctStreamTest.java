package org.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 
 * <pre>
 * 去重
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-4 9:23
 */
public class DistinctStreamTest {
	
    public static void main(String[] args) {
    	
        List<String> list1 = Arrays.asList("a","b","b","b","ac");

        // 去重
        List<?> result = list1.stream().distinct().collect(Collectors.toList());
        
        result.stream().forEach(str -> System.out.print(str + " -> "));
    }
}
