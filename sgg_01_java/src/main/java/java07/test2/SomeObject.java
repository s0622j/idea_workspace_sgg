package java07.test2;

public class SomeObject {
    // 方法重载必须发生在同一个类中
    // 多个方法方法名相同，参数组不同(参数类型不同，参数个数不同，参数顺序不同)，则构造方法重载
    public void someMethod(){
        // someMethod();// 方法自己调自己被称作递归调用
        System.out.println("in someMethod()~~~~~");
    }

    public void someMethod(int i){
        System.out.println("in someMethod(int)~~~~~~~~~~~~");
    }

    public void someMethod(String s){
        System.out.println("in someMethod(String)~~~~~~~~~~~~");
    }

    public void someMethod(String s,int i){

    }

    public void someMethod(int i,String s){

    }
}
