package java06.test2;

import java.util.Scanner;

public class TestCount {
    public static void main(String[] args) {
        Count count = new Count();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个操作数");
        count.one = input.nextInt();
        System.out.println("请输入第二个操作数");
        count.two = input.nextInt();
        System.out.println("请输入运算符");
        count.op = input.next();

        int result = count.calc();
        System.out.println("result="+result);
    }
}
