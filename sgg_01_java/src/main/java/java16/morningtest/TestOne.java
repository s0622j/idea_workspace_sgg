package java16.morningtest;

import java.io.UnsupportedEncodingException;

public class TestOne {
    public static void main(String[] args) {
        // String的常用方法
        String word = "hello";
        System.out.println(word.length());// 返回带有两端及中间空格的字符数
        try {
            byte[] datas = word.getBytes("gbk");// 将String拆解成字节数组
            String newWord = new String(datas,"utf-8");
            System.out.println(datas.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        char[] datas1 = word.toCharArray();// 将String拆解成字符数组
        System.out.println(word.trim());// 去掉两端的空格
        System.out.println(word.isEmpty());// 判断字符串是否为空
        System.out.println(word.indexOf("e"));// 从第一个字符位置开始搜索参数字符串第一次出现的位置
        System.out.println(word.indexOf("e", 1));// 从第二个参数索引位置开始搜索第一个参数字符串第一次出现的位置
        System.out.println(word.lastIndexOf("e"));// 从最后一个位置开始搜索参数字符串最后一次出现的位置
        System.out.println(word.lastIndexOf("e", 4));// 从第二个参数索引位置开始搜索第一个参数最后一次出现的位置
        System.out.println(word.substring(2));// 从参数索引开始截取到字符串末尾
        System.out.println(word.substring(0, 3));// 从第一个参数索引位置开始截取到第二个参数索引位置的前一位
        System.out.println(word.equals("hello"));// 考虑大小写的比较两个字符串是否相等
        System.out.println(word.equalsIgnoreCase("hello"));// 忽略大小写的比较两个字符串是否相等
        System.out.println(word.toLowerCase());// 将传值全转小写
        System.out.println(word.toUpperCase());// 将传值全转大写
        System.out.println(word.compareTo("world"));// 比较两个字符串的大小
        System.out.println(word.compareToIgnoreCase("WORLD"));// 忽略大小写的比较两个字符串是否相等
        System.out.println(word.replace('l', 'y'));// 用第二个参数字符替换所有的第一个参数字符
        System.out.println(word.replaceAll("l", "y"));// 使用第二个参数字符串替换所有的第一个参数字符串
        System.out.println(word.replaceFirst("l", "y"));// 使用第二个参数字符串替换第一个参数字符串
        String[] datas2 = word.split("-");// 使用参数作为分割符将原串分割成字符串数组
        System.out.println(word.matches("[a-z,A-Z]{5}"));// 判断调用方法的字符串是否符合参数正则表达式的要求
    }
}
