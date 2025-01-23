package java18.morningtest;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestOne {
    public static void main(String[] args) {
        // 自然排序
        Set set = new TreeSet();
        Student stu = new Student("Tom",20,"男");
        Student stu1 = new Student("Jerry",22,"男");
        Student stu2 = new Student("Mary",23,"女");
        Student stu3 = new Student("June",21,"女");

        set.add(stu);
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);

        for (Object o : set) {
            System.out.println(o);
        }

        System.out.println("--------------------------------------------------");

        // 定制排序
        Set set1 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student stu1 = (Student)o1;
                Student stu2 = (Student)o2;
                int result = stu2.getStuAge() - stu1.getStuAge();
                if(result == 0){
                    result = stu2.getStuName().compareTo(stu1.getStuName());
                }
                if(result == 0){
                    result = stu2.getStuGender().compareTo(stu1.getStuGender());
                }
                return result;
            }
        });

        set1.add(stu);
        set1.add(stu1);
        set1.add(stu2);
        set1.add(stu3);

        for (Object o : set1) {
            System.out.println(o);
        }
    }
}
