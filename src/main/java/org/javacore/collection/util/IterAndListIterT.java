package org.javacore.collection.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * <p>
 * 
 * <pre>
 * Iterator与ListIterator的区别
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 9:21
 */
public class IterAndListIterT {

	public static void main(String[] args) {
		iterator();
		// listIterator();
	}

	/**
	 * 并发修改异常产生。 原因：Iterator(Object obj = it.next()) 会检查HashMap的size，
	 * size发生变化，抛出错误ConcurrentModificationException。
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void iterator() {
		List a1 = new ArrayList<String>();
		a1.add("List01");
		a1.add("List02");
		a1.add("List04");
		a1.add("List05");

		Iterator i1 = a1.iterator();
		while (i1.hasNext()) {
			Object obj = i1.next();
			if (obj.equals("List02"))
				a1.add("List03");
		}

		System.out.print("集合：\n\t" + a1 + "\n");
	}

	/**
	 * ListIterator可以实现对象的修改。
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void listIterator() {
		List a1 = new ArrayList<String>();
		a1.add("List01");
		a1.add("List");
		a1.add("List03");
		a1.add("List04");

		ListIterator l1 = a1.listIterator();
		while (l1.hasNext()) {
			Object obj = l1.next();
			if (obj.equals("List")) {
				l1.remove();
				l1.add("List02");
			}
		}
		System.out.print("集合：\n\t" + a1 + "\n");
	}
}
