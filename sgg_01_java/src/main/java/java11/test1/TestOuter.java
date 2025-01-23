package java11.test1;

public class TestOuter {
    public static void main(String[] args) {
        // 在外部类类体外创建内部类对象
        // 在外部类类体外，访问内部类需要外部类类名.内部类类名
        // 静态成员内部类，在外部类类体外创建对象时，可以直接创建内部类对象，无需先创建外部类对象
        Outer.Inner1 inner1 = new Outer.Inner1();

        // 普通成员内部类，在外部类类体外创建对象，需要先创建外部类对象，再由外部类对象创建内部类对象
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        Outer.Inner innerOne = new Outer().new Inner();
    }
}
