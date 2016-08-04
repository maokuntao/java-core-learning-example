package org.javacore.collection.map;

import java.util.HashMap;


/**
 * @author taomk
 * @since 2016-8-1 18:59
 * <p>
 * 	HashMap 操作对象的决定因子：<br>
 * 	<code>hashCode()</code><br>
 * 	<code>equals(Object obj)</code>
 * </p>
 */
public class HashMapObjT{
	public static void main(String[] args){
		HashMap<A, Integer> hashMapA = new HashMap<A, Integer>();
		hashMapA.put(new A(), 10);
		hashMapA.put(new A(), 5);
		System.out.println("HashMapA Elements:");
		System.out.print("\t" + hashMapA + "\n");
		
		HashMap<B, Integer> hashMapB = new HashMap<B, Integer>();
		hashMapB.put(new B(), 10);
		hashMapB.put(new B(), 5);
		System.out.println("HashMapB Elements:");
		System.out.print("\t" + hashMapB + "\n");
		
		HashMap<C, Integer> hashMapC = new HashMap<C, Integer>();
		hashMapC.put(new C(), 10);
		hashMapC.put(new C(), 5);
		System.out.println("HashMapC Elements:");
		System.out.print("\t" + hashMapC + "\n");
	}
}

class A{
	public boolean equals(Object obj){
		return true;
	}
}

class B{
	public int hashCode(){
		return 1;
	}
}

class C{
	public int hashCode(){
		return 2;
	}

	public boolean equals(Object obj){
		return true;
	}
}