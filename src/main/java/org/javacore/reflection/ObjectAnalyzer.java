package org.javacore.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * <p>
 * 
 * <pre>
 * 反射对象分析
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 11:07
 */
public class ObjectAnalyzer {

	private ArrayList<Object> visited = new ArrayList<>();

	@SuppressWarnings("rawtypes")
	public String toString(Object obj) {

		if (obj == null)
			return "null";
		if (visited.contains(obj))
			return "...";

		visited.add(obj);

		// 获取Class对象
		Class cl = obj.getClass();

		// 如果对象是一个String对象
		if (cl == String.class)
			return (String) obj;

		// 如果对象是一个数组类
		if (cl.isArray()) {
			// 获取数组组件
			String r = cl.getComponentType() + "[]{";
			for (int i = 0; i < Array.getLength(obj); i++) {
				if (i > 0)
					r += ",";

				Object val = Array.get(obj, i);

				// 是否是一个基本类型
				if (cl.getComponentType().isPrimitive())
					r += val;
				else
					r += toString(val);// 递归
			}
			return r + "}";
		}

		String r = cl.getName();
		do {
			r += "[";
			Field[] fields = cl.getDeclaredFields();
			// 强制反射，获取私有属性
			AccessibleObject.setAccessible(fields, true);
			for (Field f : fields) {
				// 判断属性是否有static关键字修饰
				if (!Modifier.isStatic(f.getModifiers())) {
					r += f.getName() + "=";
					try {
						Class t = f.getType();
						Object val = f.get(obj);
						if (t.isPrimitive())
							r += val;
						else
							r += toString(val);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			r += "]";
			cl = cl.getSuperclass();
		} while (cl != null);

		return r;
	}

}