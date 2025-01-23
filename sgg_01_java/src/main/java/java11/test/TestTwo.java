package java11.test;

public class TestTwo {
    public static void main(String[] args) {
        // 装箱：将基础类型封装成引用类型
        int one = 100;
        Integer integer = new Integer(one);
        Integer integer1 = Integer.valueOf(one);
        // 拆箱：将包装类对象转成基础类型
        int two = integer.intValue();
        System.out.println(two);
        // jdk1.5之后可以进行自动的装箱与拆箱
        int three = new Integer(50);
        Integer integer2 = 200;
    }
}
