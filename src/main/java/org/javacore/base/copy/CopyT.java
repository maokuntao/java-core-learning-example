package org.javacore.base.copy;

/**
 * @author taomk
 * @since 2016-8-1 15:41
 *  <b>深拷贝与浅拷贝</b>
 *  <p>
 *  <i>浅拷贝：(shallow copy)，不包含对象引用指向的对象</i><br>
 *  <i>深拷贝：(deep copy)，拷贝对象包含的引用指向对象也会被拷贝</i><br>
 *  <i>将对象序列化也可以实现深拷贝，只不过会比较耗时
 *  </p>
 */

// 浅拷贝时，没必要实现Cloneable接口
class Family implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    深拷贝时，需要覆盖此方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Student implements Cloneable{
    private String name;
    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CopyT {
    public static void main(String[] args) throws CloneNotSupportedException {
        Family family = new Family();
        family.setName("Jeff Family");
        Student student1 = new Student();
        student1.setFamily(family);
        student1.setName("Jeff");

        // 浅拷贝
        // 对其对象的引用却没有拷贝
        Student student2 = (Student) student1.clone();
        student2.setName("Jeff2");
        student2.getFamily().setName("Jeff2 Family");
        System.out.println(student1.getName() + " " + student1.getFamily().getName());
        System.out.println(student2.getName() + " " + student2.getFamily().getName());

        // 深拷贝，被引用的对象在覆盖clone()方法时，
//        Student student3 = (Student) student1.clone();
//        student3.setName("Jeff2");
//        student3.getFamily().setName("Jeff2 Family");
//        System.out.println(student1.getName() + " " + student1.getFamily().getName());
//        System.out.println(student3.getName() + " " + student3.getFamily().getName());
    }
}