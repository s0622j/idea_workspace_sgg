package java06.test1;

public class Student {
    // 属性(属性有默认初始值)
    // 属性是属于类的，属性的值是属于对象的
    // 属性可以是引用数据类型，也可以是基础数据类型
    public String stuName;// 属性
    public int stuAge;
    public String stuGender;
    // 方法
    // 一个方法包含五个常规部分：访问修饰符，返回类型，方法名，参数组，方法体
    // 访问修饰符：public(公开访问) protected 缺省 private(本类访问)
    // 返回类型：方法返回值的类型，void是方法没有返回值
    public void sayHello(){
        int one;// 局部变量
        one = 100;
        if(one == 200) {
            // void的方法能写return，但return后不能有值
            return;// 提前结束方法
        }
        System.out.println(one);
        System.out.println("你好，我叫"+stuName+"，我今年"
                +stuAge+"，我是一名"+stuGender+"同学");
    }

    // 一个方法如果规定了返回类型，则在该方法结束时必须返回一个该类型的值
    // 方法的返回值返回到方法的调用点
    // 返回类型可以是任何一种出现在Java语言中的类型
    public int methodOne(){
        int result = 0;
        result = 100 + 200;
        // Java语言的方法，只能返回一个返回值
        return result;// 方法返回值使用return关键字返回
    }
}
