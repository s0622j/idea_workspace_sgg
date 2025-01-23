package java12.test1;

import java.util.Scanner;

public class TestOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入被除数");
        int one = input.nextInt();
        System.out.println("请输入除数");
        int two = input.nextInt();

        // 在出现异常的这行代码创建该类异常的对象，对象向上抛出
        // 当异常对象抛给虚拟机时，虚拟机会立即终止当前进行
        int result = one / two;

        System.out.println("result=" + result);
        System.out.println("程序结束");
    }
}
