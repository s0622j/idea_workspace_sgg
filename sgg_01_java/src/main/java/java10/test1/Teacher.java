package java10.test1;

// Teacher implements Person：Teacher实现了接口Person
// Teacher是接口Person的实现类
// 一个实现类如果实现一个接口则必须实现接口中所有的抽象方法
// Java语言中，类是单继承的，只能有一个直接父类，类可以实现多个接口，单继承多实现
// 实现接口时不会影响我们继承父类
// 一个实现类如果想实现多个接口，则必须实现所有接口中的所有抽象方法
// 一个类实现多个接口，任何一个它实现的接口需要对象都可以传递当前类的对象
public class Teacher extends Object implements Person,Comparable {
    @Override
    public void sayHello() {
        System.out.println("你好，我是一名老师");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    // 实现类对于接口中的default方法可以选择实现，也可以选择不实现
    // 如果实现类实现了接口中的default方法，则在调用会执行实现类中的方法
//    @Override
//    public void methodOne() {
//        System.out.println("in Teacher default methodOne()");
//    }

}
