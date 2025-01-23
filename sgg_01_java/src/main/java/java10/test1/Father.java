package java10.test1;

// 接口没有隐式继承
public interface Father {
    public abstract void methodOne();
}

// 接口是可以继承的，接口还可以多继承
interface Son extends Father,Comparable{
    public abstract void methodTwo();
}

// 实现类需要实现接口中的所有抽象方法
class Student implements Son{
    @Override
    public void methodOne() {

    }

    @Override
    public void methodTwo() {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
