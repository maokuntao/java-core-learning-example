package org.javacore.collection.queue;

import java.util.PriorityQueue;

/**
 * 
 * <p>
 * 
 * <pre>
 * PriorityQueue的使用
 * </pre>
 * 
 * 
 * 
 * </p>
 * 
 * @author taomk
 * @since 2016-8-1 19:24
 */
public class PriorityQueueT {
	public static void main(String[] args) {
		int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();

		for (int x : ia) {
			pq1.offer(x);
		}

		// 注意排序
		// Queue使用时要尽量避免Collection的add()和remove()方法，而是要使用offer()来加入元素，使用poll()来获取并移出元素。
		// 它们的优点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。
		// 如果要使用前端而不移出该元素，使用element()或者peek()方法。
		System.out.println("pq1: " + pq1);
	}
}