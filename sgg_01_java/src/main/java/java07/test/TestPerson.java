package java07.test;

public class TestPerson {
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        p.methodOne();// 当有方法调用时，会运行方法，当前方法暂停，当被调用方法返回后，当前方法继续执行
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
//        p.methodOne();
//        p.methodTwo();
    }
}
