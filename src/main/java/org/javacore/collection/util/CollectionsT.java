package org.javacore.collection.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * <p>
 * <pre>
 * Collections的使用
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 9:20
 */
public class CollectionsT{
	public static void main(String[] args){
		// 测试集合工具类Sort方法
		testSort();
	}
	
	/**
	 * 测试集合工具类Sort方法
	 */
	private static void testSort(){
		List<Integer> teams = new ArrayList<Integer>();
		teams.add(1);
		teams.add(3);
		teams.add(2);
		teams.add(4);
		// 调用集合工具类Sort方法
		Collections.sort(teams);
		
		System.out.println("Teams:");
		System.out.print("\t" + teams + "\n");
	}
}
