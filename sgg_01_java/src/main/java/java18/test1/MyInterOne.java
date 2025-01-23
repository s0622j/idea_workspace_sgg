package java18.test1;

// 在接口声明时声明接口支持泛型，接口中的泛型必须由实现类来确定具体类型
public interface MyInterOne<T> {
    // 泛型只能用于普通成员，泛型不支持静态
    // public static final T data = null;

    public void methodOne(T t);
    public T methodTwo();
    public T methodThree(T t);
}

// 一个不支持泛型的实现类实现一个支持泛型的接口，不给出泛型的任何信息，泛型视作Object
// class MyInterOneImpl implements MyInterOne{
// 一个不支持泛型的实现类实现一个支持泛型接口时给出泛型的具体类型，那么就一直使用这个类型
// class MyInterOneImpl implements MyInterOne<String>{
// 一个支持泛型的实现类在实现接口时继承接口的泛型，需要实现类创建对象时给出泛型的具体类型
class MyInterOneImpl<T> implements MyInterOne<T>{
    @Override
    public void methodOne(T t) {

    }

    @Override
    public T methodTwo() {
        return null;
    }

    @Override
    public T methodThree(T t) {
        return null;
    }
}
