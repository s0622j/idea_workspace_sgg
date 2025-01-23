package java07.test;

public class CalcScore {

    // 在方法声明时，小括号中声明的是方法的参数组
    // 在方法声明时声明的参数有类型和参数名，没有参数值
    // 方法声明时声明的参数被称作形参(形式参数)
    // 方法的形参可以是基础数据类型，也可以是引用数据类型
    // 方法的形参数量没有限制，多个形参间使用逗号分割
    public int calcSum(int lang,int math,int english){
        // 局部变量和形参生命周期一样，形参和局部变量不能重名
        // 局部变量的值是由方法内部确定的，形参的值是由方法调用点传入的
        int result = 0;
        result = lang + math + english;
        return result;
    }

    public int calcAvg(int lang,int math,int english){
        int result = 0;
        // 同一个类的方法可以直接互相调用
        result = this.calcSum(lang,math,english) / 3;
        return result;
    }

}
