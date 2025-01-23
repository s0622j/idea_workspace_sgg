package java21.test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestFive {
    public static void main(String[] args) {
        try {
            // 利用反射的方式创建对象并调用属性或者方法
            // 获取类类对象
            Class classOne = Student.class;
            // Student stu = new Student();
            Object obj = classOne.newInstance();// 创建类类对象代表的类的对象
            // Constructor constructor = classOne.getDeclaredConstructor(String.class,int.class,String.class);
            // Object obj = constructor.newInstance("Tom",20,"男");
            System.out.println(obj);
            // stu.stuName = "Tom";
            Field field = classOne.getDeclaredField("stuName");
            field.setAccessible(true);// 设置私有成员的公开访问特性
            field.set(obj,"Tom");
            System.out.println(field.get(obj));
            Field field1 = classOne.getDeclaredField("school");
            field1.set(null,"尚硅谷");// 静态属性可以在第一个参数传null
            System.out.println(field1.get(obj));
            // stu.setStuName("Tom");
            Method method = classOne.getDeclaredMethod("setStuName", String.class);
            method.invoke(obj,"Jerry");
            // System.out.println(stu.getStuName());
            Method method1 = classOne.getDeclaredMethod("getStuName");
            System.out.println(method1.invoke(obj));
            Method method2 = classOne.getDeclaredMethod("methodThree");
            method2.invoke(null);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
