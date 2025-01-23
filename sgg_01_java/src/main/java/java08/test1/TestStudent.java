package java08.test1;

public class TestStudent {
    public static void main(String[] args) {
        Student stu = new Student();
        // stu.stuName = "Tom";
        // System.out.println(stu.stuName);
        stu.setStuName("Tom");
        System.out.println(stu.getStuName());
        // stu.stuAge = -20;
        stu.setStuAge(18);
        System.out.println(stu.getStuAge());
    }
}
