package java08.test2;

public class TestOne {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("旺财");
        System.out.println(dog.getName());
        dog.play();
        dog.work();
        Cat cat = new Cat();
        cat.setName("汤姆");
        System.out.println(cat.getName());
        cat.play();
        System.out.println("--------------------------");
        Dog dog1 = new Dog();
        dog1.work();
        dog1.play();
        dog1.equals(null);// 比较两个对象是否相等
    }
}
