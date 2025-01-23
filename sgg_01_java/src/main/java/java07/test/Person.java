package java07.test;

public class Person {
    public String name = "Jerry";

    public void methodOne(){
        // this.name = "Tom";
        // 当一个方法被调用，则这个方法的代码顺序执行，当代码执行完方法返回
        System.out.println("4");
        System.out.println("5");
        methodTwo();
        System.out.println("6");
    }

    public void methodTwo(){
        // System.out.println(this.name);
        System.out.println("in methodTwo()");
    }
}
