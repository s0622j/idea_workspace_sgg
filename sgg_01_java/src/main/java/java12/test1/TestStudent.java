package java12.test1;

import java.io.IOException;
import java.sql.SQLException;

public class TestStudent {
    public static void main(String[] args) {
        Student stu = new Student();


        try {
            stu.setStuAge(100);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(stu.getStuAge());
    }
}
