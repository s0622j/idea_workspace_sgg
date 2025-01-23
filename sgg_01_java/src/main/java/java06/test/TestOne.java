package java06.test;

// import java.util.*;// 将一个包中所有的类都导入当前包
// import java.util.Scanner;// 将一个类导入到当前包
import java.util.Scanner;
// 任何一个Java类默认隐式导入java.lang包中所有的类
import java.lang.*;

public class TestOne {
    public static void main(String[] args) {
        // 在Java语言中，一个类只能访问和自己同包的类
        // 如果希望访问其他包的类，则必须使用import关键字将需要访问的类导入当前包
        Scanner input = new Scanner(System.in);
        System.out.println("hello");
    }
}
