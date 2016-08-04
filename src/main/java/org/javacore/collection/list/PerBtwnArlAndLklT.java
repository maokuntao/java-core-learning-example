package org.javacore.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author taomk
 * @since 2016-8-1 18:28
 *        <p>
 *        <h6>ArrayList与LinkedList性能的对比</h6>
 *        <em>1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。</em><br>
 *        <em>2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。</em><br>
 *        <em>3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。</em><br>
 *        	<span>这一点要看实际情况的。若只对单条数据插入或删除，ArrayList的速度反而优于LinkedList。但若是批量随机的插入删除数据，
 *        LinkedList的速度大大优于ArrayList. 因为ArrayList每插入一条数据，要移动插入点及之后的所有数据。</span>
 *        </p>
 */
public class PerBtwnArlAndLklT {

	public static void main(String[] args) {
		testPerBtwnArlAndLkl();
	}

	/**
	 * ArrayList与LinkedList各方法性能的对比
	 */
	public static void testPerBtwnArlAndLkl() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		// ArrayList add方法
		long startTime = System.nanoTime();
		long endTime;
		long duration;
		for (int i = 0; i < 100 * 1000; i++)
			arrayList.add(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList add:  " + duration);

		// LinkedList add方法
		startTime = System.nanoTime();
		for (int i = 0; i < 100 * 1000; i++)
			linkedList.add(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList add: " + duration);

		// ArrayList get方法
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			arrayList.get(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList get:  " + duration);

		// LinkedList get方法
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			linkedList.get(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList get: " + duration);

		// ArrayList remove方法
		startTime = System.nanoTime();
		for (int i = 9999; i >= 0; i--)
			arrayList.remove(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList remove:  " + duration);

		// LinkedList remove方法
		startTime = System.nanoTime();
		for (int i = 9999; i >= 0; i--)
			linkedList.remove(i);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList remove: " + duration);
	}
}
