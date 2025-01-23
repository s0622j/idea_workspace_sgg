package java08.test;

import java.util.Arrays;

public class Student {
    public String stuName;
    public int stuAge;
    // static关键字可以修饰属性，可以修饰方法，还可以修饰其他类的成员
    // static静态，所以static修饰的属性叫静态属性，修饰的方法叫静态方法
    // 静态属性可以不用创建对象，直接由类名调用，静态属性可以由对象名调用但是不推荐
    // 静态属性也被称作类变量，静态属性全类用一个，任何一个对象对静态属性的修改都会影响其他对象看到的属性值
    public static String school;

    public String getInfo(){
        methodOne();
        return "姓名："+stuName+"，年龄："+stuAge+"，学校："+school;
    }
    // 有static修饰的方法叫静态方法，静态方法不需要创建对象，由类名直接调用
    // 静态方法也可以由对象名调用但不推荐
    // 静态方法的传参，返回，方法入栈出栈等和普通方法一模一样
    // 静态方法和普通方法在调用入栈时不同，静态方法可以由类名调用入栈，也可以由对象名调用入栈
    // 普通方法只能由对象名调用入栈
    // 静态成员只能访问静态成员，不能访问普通成员，普通成员可以访问静态成员也可以方法普通成员
    public static void methodOne(){
        System.out.println(school);
        Student stu = new Student();
        System.out.println(stu.stuName);
        System.out.println(stu.stuAge);
        stu.getInfo();
        System.out.println("in Student static methodOne()");
    }
}
