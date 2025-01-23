package java07.test3;

public class TestStudent {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.stuName = "Tom";
        stu.stuAge = 20;
        stu.stuGender = "男";
        stu.sayHello();
        System.out.println("----------------------------------");
        Student[] students = new Student[3];
        students[0] = new Student();
        students[0].stuName = "小强";
        students[0].stuAge = 21;
        students[0].stuGender = "女";
        students[0].sayHello();
        students[1] = new Student();
        students[1].stuName = "小明";
        students[2] = new Student();
         System.out.println("-----------------------------------");
        for(int i = 0;i < students.length; i++){
            // System.out.println(students[i]);
            students[i].sayHello();
        }
    }
}
