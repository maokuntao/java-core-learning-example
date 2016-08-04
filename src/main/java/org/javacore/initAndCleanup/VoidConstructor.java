package org.javacore.initAndCleanup;
/**
 * <p>
 *	 <pre>
 * 		默认构造函数和方法的区别
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 10:02
 */
public class VoidConstructor {
	
	VoidConstructor(){
		// this is a constructor
	}
	
	/**
	 * 一个普通的方法，只不过此方法恰好跟类名一致
	 */
	void VoidConstructor() {
		// this is a method , not a constructor 
	}
}
