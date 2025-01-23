package java07.test4;

public class TestStudent {
    public static void main(String[] args) {
        // 构造器的作用是创建对象，创建对象时必须调用构造器
        Student stu = new Student("小白",22,"男");
        stu.sayHello();
        Student stu1 = new Student();
    }
}
