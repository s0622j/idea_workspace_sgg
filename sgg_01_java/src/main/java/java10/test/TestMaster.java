package java10.test;

import java.util.Arrays;

public class TestMaster {
    public static void main(String[] args) {
//        Master master = new Master();
//        MathTeacher mt = new MathTeacher();
//        LangTeacher lt = new LangTeacher();
//        EnglishTeacher et = new EnglishTeacher();
//        master.shangKe(et);

        Teacher teacher = new LangTeacher();
        teacher.jiangKe();// 方法的调用

        Teacher teacher1 = new MiddleSchoolMathTeacher();
        teacher1.jiangKe();
        MathTeacher mathTeacher = new MiddleSchoolMathTeacher();
        mathTeacher.jiangKe();

        Arrays.sort(new int[]{1,2,3});
    }
}
