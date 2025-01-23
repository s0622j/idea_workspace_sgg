package java18.test1;

// 声明类支持泛型，<>号中是泛型的数量和名称，可以声明多个泛型，每个泛型用一个大写单个的字母表示
// 泛型在类中可以担任任何一个表示类型的位置
public class MyDataTwo<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void methodOne(T t){

    }

    public T methodTwo(){
        return null;
    }

    public T methodThree(T t){
        return null;
    }
}
