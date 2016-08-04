package org.javacore.collection.set;

import java.util.HashSet;
/**
 * 
 * <p>
 * 
 * <pre>
 * HashSet 操作对象的决定因子:
 * </pre>
 * <i>hashCode()</i><br>
 * <i>equals(Object obj)</i>
 * 
 * 
 * </p>
 * 
 * @author taomk
 * @since 2016-8-1 19:34
 */
public class HashSetObjT{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args){
		HashSet objs = new HashSet();
		objs.add(new A());
		objs.add(new B());
		objs.add(new C());
		objs.add(new A());
		objs.add(new B());
		objs.add(new C());
		System.out.println("HashSet Elements:");
		System.out.print("\t" + objs + "\n");
	}
}
class A {
	public boolean equals(Object obj){
		return true;
	}
}

class B {
	public int hashCode(){
		return 1;
	}
}

class C {
	public int hashCode(){
		return 2;
	}

	public boolean equals(Object obj){
		return true;
	}
}