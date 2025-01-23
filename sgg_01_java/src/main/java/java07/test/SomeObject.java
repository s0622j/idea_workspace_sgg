package java07.test;

public class SomeObject {
    // 基础数据类型传参传的是值
    public void methodOne(int one,int two){
        System.out.println("one = "+one+",two = "+two);
        int temp = one;
        one = two;
        two = temp;
        System.out.println("one = "+one+",two = "+two);
    }
    // 引用数据类型传参传的是对象的地址
    public void methodTwo(MyNumber mn){
        System.out.println("mn.a = "+mn.a+",mn.b = "+mn.b);
        int temp = mn.a;
        mn.a = mn.b;
        mn.b = temp;
        System.out.println("mn.a = "+mn.a+",mn.b = "+mn.b);
    }
}

class MyNumber{
    public int a;
    public int b;
}