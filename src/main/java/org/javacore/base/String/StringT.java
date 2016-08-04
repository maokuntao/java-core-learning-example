package org.javacore.base.String; 

/**
 * @author taomk
 * @since 2016-8-1 16:05
 *  常见面试题：String作为方法参数传递,另外一个例子 ${@link StringT2}
 *  这就叫做“值传递”，即方法操作的是参数变量（也就是原型变量的一个值的拷贝）
 *  改变的也只是原型变量的一个拷贝而已，而非变量本身
 */
public class StringT {
    public static void main(String[] args) {
        String str = "123";
        change(str);
        System.out.println(str);
    }

    public static void change(String str) {
        str = "456";
    }
}
