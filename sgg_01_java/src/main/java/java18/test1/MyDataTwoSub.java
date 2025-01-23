package java18.test1;

// 一个不支持泛型的子类继承支持泛型的父类时没有给出泛型的信息，此时泛型的具体类型是Object
// public class MyDataTwoSub extends MyDataTwo {
// 一个不支持泛型的子类继承支持泛型的父类时给出泛型的具体类型，子类将采用固定类型来处理父类的泛型
// public class MyDataTwoSub extends MyDataTwo<String> {
// 一个子类支持泛型继承支持泛型的父类时，继承父类的泛型。
public class MyDataTwoSub<T> extends MyDataTwo<T> {
    @Override
    public T getData() {
        return super.getData();
    }

    @Override
    public void setData(T data) {
        super.setData(data);
    }
}
