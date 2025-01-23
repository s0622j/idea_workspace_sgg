package java12.test1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestTwo {
    public static void main(String[] args) {
        // try块不能独立存在，必须和catch块联合出现或者和finally块联合出现
        // 或者同时和catch块和finally出现
        // try块的作用是监控可能出现异常的代码
        // try块中的代码一旦出现异常则在出现异常的那行代码创建该类异常对象向上抛出
        // try块一旦发现有异常抛出则会立即通知catch块，告诉catch块抛出异常的种类
        // 同时try开中剩余的代码不执行，try块代码结束
        // try块中没有异常对象抛出，则正常执行try块，没有异常则不进入catch块
        try {
            Class.forName("");

            Scanner input = new Scanner(System.in);
            System.out.println("请输入被除数");
            int one = input.nextInt();
            System.out.println("请输入除数");
            int two = input.nextInt();

            // 在出现异常的这行代码创建该类异常的对象，对象向上抛出
            // 当异常对象抛给虚拟机时，虚拟机会立即终止当前进行
            int result = one / two;

            System.out.println("result=" + result);
        } catch (ArithmeticException e) {
            // catch根据自己的参数确定捕获异常的种类，按照参数捕获异常
            // 一旦异常捕获成功，则进入catch块执行catch块代码
            // 如果捕获失败则异常对象会继续抛出
            e.printStackTrace();
        } catch (InputMismatchException e){
            // catch块的数量不受限制，按照编写catch块的顺序依次匹配异常对象
            // 如果当前catch块匹配异常成功，则进入当前catch块执行代码
            // 代码执行完毕退出整个try-catch结构，后续catch块不执行
            // 如果当前catch块匹配异常不成功，则依稀向下匹配下面catch块的异常
            e.printStackTrace();
        } catch (Exception e){// catch块捕获Exception，由于任何一个异常对象都是Exception及其子类的对象，则必然匹配成功
            e.printStackTrace();
        }
        System.out.println("程序结束");
    }
}
