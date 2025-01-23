package java07.test4;

public class Student {
    public String stuName;
    public int stuAge;
    public String stuGender;

    // 在一个类中，如果没有任何一个显示的构造器，则系统为我们配备一个隐示无参的构造器
    // 构造器必须与类同名，构造器没有返回类型
    // 构造器只能在创建对象时调用
    // 如果有任何一个显示构造器存在，则隐式无参构造器自动消失
    public Student(){
    }


    public Student(String stuName,int stuAge,String stuGender){
        // 局部变量(形参)可以和属性重名
        // 一旦重名局部变量拥有更高的优先级
        // 在重名状态下，想访问属性需要加this
        // 构造器的作用是为对象进行初始化
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuGender = stuGender;
    }

    public void sayHello(){
        System.out.println("学生名："+stuName+"，学生年龄："
                +stuAge+"，学生性别："+stuGender);
    }
}
