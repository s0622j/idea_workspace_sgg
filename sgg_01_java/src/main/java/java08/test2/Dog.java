package java08.test2;

// Dog extends Pet Dog类继承自Pet类，Dog是子类Pet是父类
// 子类可以继承到父类所有的属性和方法，构造器不能继承
// Java只支持单继承不支持多继承，一个Java类只能有一个直接父类
// Java支持多层次继承，一个类可以有直接父类，也可以有间接父类
// 子类继承父类的属性和方法有遗传性，子类不仅可以继承直接父类的属性方法
// 子类也可以继承间接父类的属性方法
public class Dog extends Pet{

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void work(){
        // 子类不能直接访问父类标注private的属性和方法
        // name = "Tom";
        setName("Tom");
        System.out.println("工作");
    }

    // 子类认为从父类继承到的方法无法体现子类的特征，方法重写
    // 方法重写：必须发生在父子类中，子类编写一个和父类方法签名一模一样的方法
    // 一旦发生方法重写，子类对象再调用的方法一定是子类重写之后的方法
    // 子类重写父类方法时子类重写的方法访问修饰符只能比父类宽不能比父类窄
    // private修饰的方法子类不能重写
    // 如果父类的方法返回类型是void或者是基础数据类型，则子类重写父类方法返回类型必须和父类一致
    // 如果父类方法的返回类型是引用数据类型，那么子类重写父类方法时返回类型可以是父类方法返回类型的子类型
    // 子类重写父类方法时，如果父类方法抛出异常，则子类可以和父类方法抛出同样的异常，也可以抛出父类方法抛出异常的子异常
    public Cat play(){
        // 在子类类体中，可以使用super关键字代指父类对象，调用父类重写前的方法
        super.play();
        // this.play();
        System.out.println("玩儿丢飞盘");
        return null;
    }
}
