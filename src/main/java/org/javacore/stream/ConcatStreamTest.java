package org.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 
 * <pre>
 * 组合 - 流
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 16:56
 */
public class ConcatStreamTest {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a","b","c");
        List<String> list2 = Arrays.asList("d","e","f");

        // 组合list1和list2的流
        List<?> result = Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
        result.stream().forEach(System.out::println);
    }
}
