package org.javacore.collection.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * <p>
 * 
 * <pre>
 * TreeMap的使用
 * </pre>
 * 
 * 
 * 
 * </p>
 * 
 * @author taomk
 * @since 2016-8-1 19:14
 */
public class TreeMapT
{	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args)
	{
		Map map = new TreeMap();
		map.put("1", "1");
		map.put("4", "4");
		map.put("2", "2");
		map.put("2", "3");
		// 注意排序
		System.out.println(map);
	}
}