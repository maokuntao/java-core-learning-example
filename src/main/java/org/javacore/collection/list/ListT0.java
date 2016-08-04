package org.javacore.collection.list; 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author taomk
 * @since 2016-8-1 16:29
 * <p>
 *  <b>打印list 全部元素，并找到其中元素aaa删除。</b><br>
 *  <i>要求：所有元素都遍历完(ListIterator 的使用)</i><br>
 *  <i>list那个remove会抛异常是因为快速失败的机制，
 *  他内置了一个modifyCount的变量记录list的长度变化，用Iter可以删除掉</i>
 * </p>
 */
public class ListT0 {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("aaa");
        list.add("6");
        list.add("7");
        

//        ListIterator<String> listIterator = list.listIterator();
        Iterator<String> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            Object o = listIterator.next();
            System.out.println(o);
            if (o.equals("aaa")) {
	            	list.remove(o);// 直接从list中remove元素将会产生并发修改异常(ConcurrentModificationException)
//                listIterator.remove();
            }
        }
    }

}
