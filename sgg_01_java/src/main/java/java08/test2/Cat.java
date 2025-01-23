package java08.test2;

public class Cat extends Pet{
    // 访问修饰符只能修饰类的成员

    // 检查方法重写是否符合语法规范
//    @Override
//    public Pet play(){
//        System.out.println("玩儿毛线球");
//        return null;
//    }


    @Override
    public Pet play() {
        System.out.println("玩儿毛线球");
        return null;
    }
}
