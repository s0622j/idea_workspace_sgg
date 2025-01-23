package java10.test;

// 一个普通子类继承自抽象父类，必须重写抽象父类中所有的抽象方法
public class LangTeacher extends Teacher {
    public LangTeacher(){
        // 子类必须在构造器的第一行调用父类的构造器
        // 在隐式情况下，调用父类的无参构造器
        // super("Tom",20);
    }

    @Override
    public void jiangKe() {
        System.out.println("讲语文课");
    }
}
