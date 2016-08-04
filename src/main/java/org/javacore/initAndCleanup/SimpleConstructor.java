package org.javacore.initAndCleanup;
/**
 * <p>
 *	 <pre>
 * 		简单构造器
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 10:00
 */
public class SimpleConstructor {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Child();
		}
	}
}

// Child类
class Child {
	Child() { // Child类的构造器
		System.out.print("Child init... ");
	}
}