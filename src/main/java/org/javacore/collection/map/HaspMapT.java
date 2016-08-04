package org.javacore.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>
 * 
 * <pre>
 * HashMap的Add方法
 * </pre>
 * 
 * 
 * 
 * </p>
 * 
 * @author taomk
 * @since 2016-8-1 19:07
 */
public class HaspMapT {
	public static void main(String[] args) {
		objOper();
		nullOper();
	}

	/**
	 * HaspMap操作对象方法
	 */
	public static void objOper() {
		Map<String, Employee> employees = new HashMap<String, Employee>();

		String number = "1206010035";
		// 设置对象
		employees.put(number, new Employee());
		System.out.println(employees);

		// 获取对象
		System.out.println(employees.get(number));
	}

	/**
	 * HaspMap的put方法
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void nullOper() {
		Map map = new HashMap<String, String>();
		map.put(null, "null01");
		map.put(null, "null02");
		System.out.println(map);
		System.out.println(map.get(null));
	}
}

class Employee {
}