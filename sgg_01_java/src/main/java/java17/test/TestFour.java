package java17.test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestFour {
    public static void main(String[] args) {
        // 定制排序：集合本身可以排序，不需要元素排序
        // 自然排序和定制排序同时存在时，定制排序优先级更高
        Set set = new TreeSet(new Comparator(){
            // 返回负数代表第一个参数小，第二个参数大
            // 返回正数代表第一个参数大，第二个参数小
            // 返回0代表两个参数相等
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
        });// 传入比较器对象

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
