package java17.test;

import java.util.Set;
import java.util.TreeSet;

public class TestThree {
    public static void main(String[] args) {
        // TreeSet的特点：底层使用红黑树存储元素
        // TreeSet中存储的元素必须能比较大小，通过自然排序或者定制排序类比较大小
        // 放入TreeSet集合中的元素自己可以排序，则成为自然排序
        Set set = new TreeSet();

//        set.add("Aom");
//        set.add("Jerry");
//        set.add("Jary");
//        set.add("June");

        Student stu = new Student("Tom",20,"男");
        Student stu1 = new Student("Jerry",20,"男");
        Student stu2 = new Student("Mary",23,"女");
        Student stu3 = new Student("June",21,"女");

        set.add(stu);
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);

        for (Object o : set) {
            System.out.println(o);
        }
    }
}
