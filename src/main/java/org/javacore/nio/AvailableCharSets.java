package org.javacore.nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;


/**
 * <p>
 * 
 * <pre>
 * 可用的CharSet打印
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 15:56
 */
public class AvailableCharSets {
	
    public static void main(String[] args) {
    	
        // charset对象的有序映射
        SortedMap<String,Charset> charSets =
                Charset.availableCharsets();
        
        // 获取key的迭代器
        Iterator<String> iterator = charSets.keySet().iterator();
        while (iterator.hasNext()) {
            String csName = iterator.next();
            System.out.print(csName);
            // 获取别名的Charset集合的迭代器
            Iterator<String> aliases =
                    charSets.get(csName).aliases().iterator();
            if (aliases.hasNext())
                System.out.print("： ");
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext())
                    System.out.print(",");
            }
            System.out.println();
        }
    }
}
