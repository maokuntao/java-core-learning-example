package org.javacore.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * <p>
 * 
 * <pre>
 * 反射对象构造函数、方法及字段
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 11:16
 */
public class ReflectionTest {

	public static final int AGE = 1;

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Class cl = null;
		try {
			cl = Class.forName("org.javacore.reflection.ReflectionTest");
			System.out.println("打印析构函数：");
			printConstructors(cl);
			System.out.println("打印方法：");
			printMethods(cl);
			System.out.println("打印字段：");
			printFields(cl);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打印Class对象的析构方法
	 * 
	 * @param cl
	 */
	@SuppressWarnings("rawtypes")
	public static void printConstructors(Class cl) {

		// 返回类所有的析构方法
		Constructor[] constructors = cl.getDeclaredConstructors();
		for (Constructor c : constructors) {
			// 返回析构方法名称
			String name = c.getName();
			System.out.print("\t");
			// 获取Java语言的修饰符
			// 修饰符由 Java 虚拟机的 public、protected、private、
			// final、static、abstract 和 interface 对应的常量组成；
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");

			System.out.print(name + "(");

			// 获取析构方法的参数对象列表数组
			Class[] paramTypes = c.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0)
					System.out.print(", ");
				System.out.print(paramTypes[i].getName());
			}

			System.out.println(");");
		}
	}

	/**
	 * 打印对象所有的方法
	 * 
	 * @param cl
	 */
	@SuppressWarnings("rawtypes")
	public static void printMethods(Class cl) {

		// 获取类所有方法对象数组
		Method[] methods = cl.getMethods();
		for (Method m : methods) {
			// 获取方法返回对象
			Class retType = m.getReturnType();
			String name = m.getName();

			System.out.print("\t");
			// 获取Java语言的修饰符
			// 修饰符由 Java 虚拟机的 public、protected、private、
			// final、static、abstract 和 interface 对应的常量组成；
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");

			System.out.print(retType.getName() + " " + name + "(");

			// 获取方法的参数对象列表数组
			Class[] paramTypes = m.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0)
					System.out.print(", ");
				System.out.print(paramTypes[i].getName());
			}

			System.out.println(");");
		}
	}

	@SuppressWarnings("rawtypes")
	public static void printFields(Class clazz) {

		// 获取字段Field对象数组
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			// 获取字段声明类型对象
			Class type = field.getType();
			// 获取字段名称
			String name = field.getName();

			System.out.print("\t");
			// 获取Java语言的修饰符
			// 修饰符由 Java 虚拟机的 public、protected、private、
			// final、static、abstract 和 interface 对应的常量组成；
			String modifiers = Modifier.toString(field.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");
			
			System.out.print(type.getName() + " " + name);
		}
	}
}
