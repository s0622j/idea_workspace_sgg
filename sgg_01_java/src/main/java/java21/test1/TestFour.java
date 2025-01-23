package java21.test1;

import java.lang.reflect.Constructor;

public class TestFour {
    public static void main(String[] args) {
        // Class类的常用方法
        Class classOne = Student.class;

        Constructor[] cs1 = classOne.getConstructors();// 获取所有public修饰的构造器
        System.out.println(cs1.length);
        Constructor[] cs2 = classOne.getDeclaredConstructors();// 获取所有修饰符修饰的构造器
        System.out.println(cs2.length);
        try {
            Constructor c1 = classOne.getConstructor();// 根据参数列表获取public修饰的构造器
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            Constructor c2 = classOne.getDeclaredConstructor(String.class,int.class,String.class);// 根据参数列表获取所有修饰符修饰的构造器
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
