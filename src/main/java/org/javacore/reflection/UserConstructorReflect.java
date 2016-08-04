package org.javacore.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/**
 * <p>
 * 
 * <pre>
 * 利用反射通过构造器创建一个实例
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 11:24
 */
public class UserConstructorReflect {
	
	public static void main(String[] args) throws NoSuchMethodException,
		SecurityException, InstantiationException,
		IllegalAccessException, IllegalArgumentException, 
		InvocationTargetException {
		
		// 获取User类型
		Class<?> userClass = User.class;
		// 获取默认构造器
		Constructor<?> constructor = userClass.getConstructor();
		// 获取带int参数的构造器
		Constructor<?> intConstructor = userClass.getConstructor(int.class);
		// 获取带int和String参数的构造器
		Constructor<?> bothConstructor = userClass.getConstructor(int.class,String.class);
		
		// 使用反射，获取新的User对象
		User u1 = (User) constructor.newInstance();
		User u2 = (User) intConstructor.newInstance(1);
		User u3 = (User) bothConstructor.newInstance(2,"taomk");
		
		System.out.println(u1.toString());
		System.out.println(u2.toString());
		System.out.println(u3.toString());
	}
}
