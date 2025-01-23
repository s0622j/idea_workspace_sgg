package java10.test1;

// 接口不允许实例化
public interface Person {
    // 在接口中声明的属性默认修饰是public static final修饰
    public static final String NAME = "Tom";

    // 在接口中声明的方法默认修饰是public abstract
    public abstract void sayHello();

    // 从JDK1.8开始接口中允许有default修饰的方法
    // default修饰的方法有方法体，default修饰的方法不强制实现类必须实现
    // default修饰的方法由实现类创建对象，再由实现类对象调用default的方法
    public default void methodOne(){
        System.out.println("in Person default methodOne()");
    }

    // 从JDK1.8开始，接口中允许出现static修饰的方法
    // 由static修饰的方法有方法体
    // 由static修饰的方法由接口名.方法名的方式调用，不允许使用实现类对象去调用的
    public static void methodTwo(){
        System.out.println("in Person static methodTwo()");
    }
}
