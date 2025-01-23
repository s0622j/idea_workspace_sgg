package java15.test1;

import java.io.UnsupportedEncodingException;

public class TestTwo {
    public static void main(String[] args) {
        // String类的常用方法
        String s1 = "hello";
        String s2 = "Hello";
        System.out.println(s1.equals(s2));// 考虑大小写的比较两个字符串是否相等
        System.out.println(s1.equalsIgnoreCase(s2));// 忽略大小写的比较两个字符串是否相等
        System.out.println(s1.concat(s2));// 拼接两个字符串
        System.out.println(s1.toLowerCase().equals(s2.toLowerCase()));
        System.out.println(s1.toUpperCase());// 全转大写
        System.out.println(s1.toLowerCase());// 全转小写
        char c = s1.charAt(0);// 返回指定下标处的字符
        System.out.println(c);
        System.out.println("aab".compareTo("aaa"));// 比较两个字符串的大小
        System.out.println("hello world".endsWith("world"));// 比较调用方法的字符串是否以参数字符串结尾
        System.out.println("hello world".startsWith("He"));// 比较调用方法的字符串是否以参数字符串开头
        System.out.println("好好学习".length());// 返回包含两端及中间空格的字符数
        byte[] data1 = "好好学习".getBytes();// 将字符串变成字节数组
        System.out.println(data1.length);
        try {
            byte[] data3 = "hello".getBytes("utf-8");// 使用参数指定的编码格式将字符串拆成字节数组
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        char[] data2 = "hello world".toCharArray();// 将字符串变成char型数组
        System.out.println(" hello world ".trim().length());// 去掉两端的空格
    }
}
