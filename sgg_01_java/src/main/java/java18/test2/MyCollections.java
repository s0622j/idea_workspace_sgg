package java18.test2;

public class MyCollections {
    // 泛型的方法，类不支持泛型，方法必须是静态的，然后在static关键字后声明泛型
    public static<T> T sort(T t){
        System.out.println(t.getClass().getName());
        return t;
    }
}
