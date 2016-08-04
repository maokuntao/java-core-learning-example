package org.javacore.rtti;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * <p>
 * 
 * <pre>
 * 获取Class方法
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 14:27
 */
public class ShowMethods {
	
    @SuppressWarnings("rawtypes")
	public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("org.javacore.rtti.ShowMethods");
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            for (Method m : methods)
                System.out.println(m.toGenericString());
            for (Constructor constructor : constructors)
                System.out.println(constructor.toGenericString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
