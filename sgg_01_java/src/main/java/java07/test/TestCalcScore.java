package java07.test;

import java.util.Scanner;

public class TestCalcScore {
    public static void main(String[] args) {
        CalcScore cs = new CalcScore();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入语文分数");
        int yi = input.nextInt();
        System.out.println("请输入数学分数");
        int er = input.nextInt();
        System.out.println("请输入英语分数");
        int san = input.nextInt();
        // 调用方法传入的参数被称作实参(实际参数)
        // 实参和形参名字无所谓，但是形参和实参类型必须一致
        // 在调用方法传递实参时，是使用实参的值为形参赋值
        int sum = cs.calcSum(yi,er,san);// 调用带参的方法必须按照方法要求传参(参数类型要求，参数个数要求，参数顺序要求)
        System.out.println("sum="+sum);
        int avg = cs.calcAvg(yi,er,san);
        System.out.println("avg="+avg);
    }
}
