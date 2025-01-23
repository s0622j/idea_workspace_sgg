package java08.test;

public class TestStudent {
    public static void main(String[] args) {
        // 静态的属性随着累的加载在方法区分配内存空间
        Student.school = "尚硅谷";
        Student.methodOne();
        Student stu = new Student();
        // 普通属性随着对象的创建在堆空间中分配内存空间
        stu.stuName = "Tom";
        stu.stuAge = 20;
        stu.school = "清华";
        System.out.println(stu.getInfo());
        System.out.println(stu.school);
        stu.methodOne();
        Student stu1 = new Student();
        stu1.stuName = "Jerry";
        stu1.stuAge = 22;
        stu1.school = "北大";
        System.out.println(stu1.getInfo());
        System.out.println(stu1.school);
        System.out.println(stu.school);
    }
}
