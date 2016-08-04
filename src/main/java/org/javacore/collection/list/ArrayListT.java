package org.javacore.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author taomk
 * @since 2016-8-1 16:27
 * 	ArrayList的使用
 */
public class ArrayListT{
	
	public static void main(String[] args){
		listMethods();
	}
	
	/**
	 * 测试ArrayList基本操作方法，其脚标的使用及迭代器next()的使用。
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void listMethods(){
		List a1 = new ArrayList<String>();
		a1.add("List01");
		a1.add("List03");
		a1.add("List04");
		System.out.print("原来集合：\n\t"+a1+"\n");
		a1.add(1,"List02");
		System.out.print("指定脚标1插入：\n\t"+a1+"\n");
		a1.remove(2);
		System.out.print("指定脚标2删除：\n\t"+a1+"\n");
		System.out.print("指定脚标2查询：\n\t"+a1.get(2)+"\n");
		
		Iterator i1 = a1.iterator();
		System.out.println("用迭代器查询全部元素：");
		while (i1.hasNext())
			System.out.print(i1.next()+"\t");
	}
}
