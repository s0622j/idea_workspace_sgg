package java21.test1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestTwo {
    public static void main(String[] args) {
        // Class类的常用方法
        Class classOne = Student.class;

        System.out.println(classOne.getName());// 获取类的完整类名
        System.out.println(classOne.getSimpleName());// 获取类的简单类名
        System.out.println(classOne.getPackage());// 获取类的包对象
        System.out.println(classOne.getSuperclass().getName());// 获取父类的类类对象
        Field[] fields = classOne.getFields();// 返回类中所有public修饰的属性，不仅限本类，包含从父类继承到的属性
        System.out.println(fields.length);
        System.out.println("-------------------------------------");
        for (Field field : fields) {
            System.out.println(field.getModifiers());
            System.out.println(field.getName());// 获取属性名
        }
        System.out.println("-----------------------------------");
        Field[] fields1 = classOne.getDeclaredFields();// 返回所有修饰符修饰的属性，仅限本类
        // System.out.println(fields1.length);
        for (Field field : fields1) {
            System.out.println(field.getModifiers());
            String modStr = Modifier.toString(field.getModifiers());
            System.out.println(modStr);
            System.out.println(field.getType().getSimpleName());
            System.out.println(field.getName());
        }
        System.out.println("-----------------------------------");
        try {
            Field field = classOne.getField("two");// 根据参数属性名获取单个属性，仅能获取public修饰的属性，不仅限本类，包含从父类继承到的属性
            System.out.println(field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            Field field = classOne.getDeclaredField("one");// 根据参数属性名获取单个属性，可以获取所有修饰符修饰的属性，仅限本类
            System.out.println(field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
