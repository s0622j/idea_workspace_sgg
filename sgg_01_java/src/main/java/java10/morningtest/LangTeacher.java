package java10.morningtest;

public class LangTeacher extends Teacher {
    public LangTeacher(){
        // 子类必须在构造器的第一行调用父类的构造器
        // 在隐式情况下，调用父类的无参构造器
        super("Tom",20);
    }
    @Override
    public void jiangKe() {
        System.out.println("上语文课");
    }
}
