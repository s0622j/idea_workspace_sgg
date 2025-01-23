package java12.test1;

import java.io.IOException;
import java.sql.SQLException;

public class Student {
    private String stuName;
    private int stuAge;
    private String stuGender;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    // throws关键字声明方法抛出何种异常，一旦方法声明抛出某类异常，则编译器不会强制必须处理此类异常
    // 方法声明抛出异常则方法的调用点必须处理异常
    // throws关键字可以声明方法抛出多个异常，多个异常间用逗号分割
    // public void setStuAge(int stuAge)throws SQLException,ClassNotFoundException, IOException {
    public void setStuAge(int stuAge)throws StudentAgeException {
        if(stuAge >= 20 && stuAge <= 40) {
            this.stuAge = stuAge;
        }else{
            // throw关键字的作用是抛出手动创建的异常对象
            // throw new RuntimeException("学员年龄必须在20-40之间");
            // throw new Exception("学员年龄必须在20-40之间");
            // throw new StudentAgeException("学员年龄必须在20-40之间");
            throw new StudentAgeException();
        }
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }
}
