package java09.test1;

public class TestStudent {
    public static void main(String[] args) {
        Student stu = new Student("Tom",20,"男");
        // Student stu1 = new Student("Jerry",21,"男");
        Student stu1 = stu;

        Student one = new Student();
        one = new Student();

        // System.out.println(new Student());// 匿名对象

        Student two = null;

        Student stu2 = new Student("Mary",22,"女");
        Student stu3 = new Student("Tom",23,"女");
        // System.out.println(stu);
        System.out.println(stu2 == stu3);
        System.out.println(stu2.equals(stu3));

        Student stu4 = new Student("小明",23,"男");
        Student stu5 = new Student("小明",23,"男");
        System.out.println(stu4 == stu5);
        System.out.println(stu4.equals(stu5));

    }
}
