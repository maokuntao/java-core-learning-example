package org.javacore.initAndCleanup;
/**
 * <p>
 *	 <pre>
 * 		带参数的简单构造器
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 10:01
 */
public class SimpleConstructor2 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Child2(i);
		}
	}
}

// Child类
class Child2 {
	Child2(int i) {// 带参数的Child类构造器
		System.out.print("Child init " + i + " ");
	}
}