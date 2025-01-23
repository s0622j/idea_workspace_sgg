package java10.test1;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Teacher();
        person.sayHello();
        person.methodOne();
        Person.methodTwo();// 接口中的静态方法由接口名调用
        // person.methodTwo();// 接口中的静态方法不允许使用对象名调用
    }
}
