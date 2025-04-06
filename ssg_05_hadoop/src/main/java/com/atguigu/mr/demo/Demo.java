package com.atguigu.mr.demo;

public class Demo {

    public static void main(String[] args) {
        int i=10;
        int a=2;
        say();
        int sum=i+a;
        System.out.println("sum=="+sum);
    }

    public static void say(){
        String s="abc";
        int a = 20;
        test();
        System.out.println("abc");
    }

    public static  void test(){
        String s = "a-b-c";
        String[] split = s.split("-");
        for (String s1 : split) {
            System.out.println(s1);
        }
    }
}
