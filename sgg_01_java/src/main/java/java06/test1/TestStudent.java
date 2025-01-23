package java06.test1;

public class TestStudent {
    public static void main(String[] args) {
        // 需要使用一个类的属性或者方法时必须创建这个类的对象
        // 使用对象名.属性名，对象名.方法名()的方式调用属性或者方法
        Student stu = new Student();// 实例化Student类(创建Student类的对象)
        stu.stuName = "Tom";
        stu.stuAge = 20;
        stu.stuGender = "男";
        stu.sayHello();
        Student stu1 = new Student();
        stu1.stuName = "Jerry";
        stu1.stuAge = 22;
        stu1.stuGender = "男";
        stu1.sayHello();
        System.out.println("--------------------------------");
        // 如果需要方法的返回值为变量赋值，则必须要求方法的返回类型和变量类型一致
        int one = stu.methodOne();// 方法的返回值返回到方法的调用点
        System.out.println(one);
        System.out.println(stu.methodOne());
        // String two = stu.sayHello();
        // System.out.println(stu.sayHello());
    }
}
