package java10.morningtest;

public class TestMaster {
    public static void main(String[] args) {
        Master master = new Master();
        MathTeacher mt = new MathTeacher();
        LangTeacher lt = new LangTeacher();
        EnglishTeacher et = new EnglishTeacher();
        master.shangKe(et);
    }
}
