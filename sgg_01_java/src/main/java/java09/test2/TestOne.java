package java09.test2;

public class TestOne {
    public static void main(String[] args) {
        Master master = new Master();
        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();
        // 多态：任何一个需要父类引用的位置都可以传递一个子类对象
        // 实现多态的三个关键步骤：
        // 1、必须有继承，必须有父子类
        // 2、父类定义方法，子类重写方法
        // 3、父类的引用指向子类的对象
        master.playWithPet(bird);

        Pet pet = new Dog();// 多态：父类的引用子类的对象
        pet.play();
        Pet pet1 = new Cat();
        pet1.play();
        Cat cat1 = new Cat();
        Pet pet2 = cat1;

        Dog dog1 = new Dog();// 本态：本类的引用本类的对象
        dog1.play();

    }
}
