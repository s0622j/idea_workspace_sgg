package java17.test;

import java.util.HashSet;
import java.util.Set;

public class TestStudent {
    public static void main(String[] args) {
        // HashSet集合需要元素调用hashCode和equals两个方法去重，在不重写这两个方法的情况下
        // HashSet只能去掉来自于同一个内存地址的多个对象，如果需要属性相同即判定相等，则需要
        // 元素重写hashCode和equals方法。元素会首先调用hashCode方法，如果hashCode方法判定元素不相等
        // 则不需要调用equals方法，直接新增元素。如果hashCode判定元素相等，则需要调用equals方法
        // equals方法判定元素不相等则新增元素，如果equals方法判定元素相等则不执行新增操作
        Set set = new HashSet();

        Student stu = new Student("Tom",20,"男");
        Student stu1 = new Student("Jerry",22,"男");
        Student stu2 = new Student("Mary",23,"女");
        Student stu3 = new Student("June",21,"女");
        Student stu4 = new Student("June",21,"女");
        Student stu5 = new Student("June",21,"女");

        set.add(stu);
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        set.add(stu4);
        set.add(stu5);

        for (Object o : set) {
            System.out.println(o);
        }
    }
}
