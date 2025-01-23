package java17.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestFive {
    public static void main(String[] args) {
        // Collections工具类
        List list = new ArrayList();

        list.add("Tom");
        list.add("Jerry");
        System.out.println(list);
        Collections.addAll(list,"Mary","June","Jack");
        System.out.println(list);
        Collections.sort(list);// 让集合中的元素自然排序
        System.out.println(list);
        int index = Collections.binarySearch(list,"Mary");// 二分查找法
        System.out.println(index);

        List list1 = new ArrayList();
        Student stu = new Student("Tom",20,"男");
        Student stu1 = new Student("Jerry",24,"男");
        Student stu2 = new Student("Mary",23,"女");
        Student stu3 = new Student("June",21,"女");

        list1.add(stu);
        list1.add(stu1);
        list1.add(stu2);
        list1.add(stu3);
        for (Object o : list1) {
            System.out.println(o);
        }
        Collections.sort(list1, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student s1 = (Student)o1;
                Student s2 = (Student)o2;
                int result = s2.getStuAge() - s1.getStuAge();
                return result;
            }
        });
        System.out.println("-------------------------------------");
        for (Object o : list1) {
            System.out.println(o);
        }
        System.out.println("------------------------------------------");
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.swap(list,1,3);
        System.out.println(list);
    }
}
