package org.javacore.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 
 * <pre>
 * Stream API 集合的流式操作
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 14:38
 */
public class CollectionStreamTest {
	
    public static void main(String[] args) {
    	
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("cccc");
        list.add("bbb");

        /**
         * Stream的使用:
         *  创建/获取流 -> 中间操作（过滤、转换等） -> 终止操作（ 聚合、收集结果）
         */
        list.stream().forEach(System.out::println);
        System.out.println();

        /**
         * 过滤
         *      collect语法 {@link StreamCollectTest}
         */
        List<?> list0 = list.stream().filter(str -> str.startsWith("cc")).collect(Collectors.toList());
        List<?> list1 = list.stream().filter(str -> str.startsWith("aa")).collect(Collectors.toList());

        list0.stream().forEach(System.out::println);
        list1.stream().forEach(System.out::println);
        System.out.println();

        /**
         * 转换
         */
        List<?> list2 = list.stream().map(str -> str.replace("c","*")).collect(Collectors.toList());

        list2.stream().forEach(System.out::println);
        System.out.println();

        /**
         * 提取
         *      从skip开始至limit位置为止(包含起始位置，不包含终止位置)
         */
        List<?> list3 = list.stream().skip(0).limit(1).collect(Collectors.toList());

        list3.stream().forEach(System.out::println);
        System.out.println();

        /**
         * 组合
         */
        List<?> list4 = Stream.concat(list.stream(),list.stream()).collect(Collectors.toList());

        list4.stream().forEach(System.out::println);
        System.out.println();
    }
}
