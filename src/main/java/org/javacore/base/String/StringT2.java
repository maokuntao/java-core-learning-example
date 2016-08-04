package org.javacore.base.String; 

/**
 * @author BYSocket
 * @since 2016-01-06 20:07:00
 * 对象含有String作为方法参数传递
 */
public class StringT2 {

    public static void main(String[] args) {
        StringObject sb = new StringObject();
        sb.setName("123");
        change(sb);
        System.out.println(sb.getName());
    }

    public static void change(StringObject sb) {
//        sb = new StringObject(); // 去掉注释，返回的结果不同
        sb.setName("456");
    }

}
class StringObject {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}