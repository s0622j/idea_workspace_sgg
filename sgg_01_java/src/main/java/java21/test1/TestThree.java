package java21.test1;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestThree {
    public static void main(String[] args) {
        // Class类的常用方法
        Class classOne = Student.class;

        Method[] methods = classOne.getMethods();// 获取所有public修饰的方法，不仅限本类，包含从父类继承到的
        for (Method method : methods) {
            String str = Modifier.toString(method.getModifiers());
            System.out.println(str);
            System.out.println(method.getReturnType().getSimpleName());
            System.out.println(method.getName());
            Class[] classes = method.getParameterTypes();
            for (Class aClass : classes) {
                System.out.print(aClass.getSimpleName()+" ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
        Method[] methods1 = classOne.getDeclaredMethods();// 获取所有修饰符修饰的方法，仅限本类
        for (Method method : methods1) {
            System.out.println(method.getName());
        }
        System.out.println("---------------------------------------------");
        try {
            Method method = classOne.getMethod("methodOne");// 根据参数方法名获取单个的public修饰的方法，不仅限本类，包含从父类继承到的方法
            System.out.println(method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            // 获取单个方法，无参方法只写方法名，有参方法除了方法名还需要写出参数组
            Method method = classOne.getDeclaredMethod("sayHello",String.class,int.class);// 获取所有修饰符修饰的方法，仅限本类
            System.out.println(method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
