package org.javacore.collection.set;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * <p>
 * 
 * <pre>
 * HashSet的Add方法
 * </pre>
 * 
 * 
 * 
 * </p>
 * 
 * @author taomk
 * @since 2016-8-1 21:29
 */
public class HashSetT{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args){
		Set h1 = new HashSet<String>();
		h1.add("List");
		h1.add(new String("List"));
		h1.add("List");
		h1.add("Set");
		h1.add("Queue");
		h1.add("Map");
		// 注意排序
		System.out.println("HashSet Elements:");
		System.out.print("\t" + h1 + "\n");
	}
}
