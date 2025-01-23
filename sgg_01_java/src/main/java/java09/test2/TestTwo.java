package java09.test2;

public class TestTwo {
    public static void main(String[] args) {
        // 在多态状态下，只能看见父类中定义的方法，子类定义的独有方法无法看见
        // 引用调用方法时必须看引用数据类型，方法运行时体现对象的方法的特征
        // 编译时类型 = new 运行时类型
        // 能调用什么方法看编译时类型，方法运行体现的特点是运行时类型的特点
        Pet pet = new Dog();// 向上转型(自动)
        pet.play();
        // pet.work();
        Dog dog = (Dog)pet;// 向下转型(手动)
        dog.work();
        System.out.println("----------------------------------");
        Master master = new Master();
        // master.playWithPet(new Dog());
        Dog dog1 = new Dog();
        master.playWithPet(dog1);
        Cat cat1 = new Cat();
        master.playWithPet(cat1);

    }
}
