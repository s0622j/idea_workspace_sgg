package java08.test2;

// 如果一个类没有显示的继承，则该类隐式继承自Object
// 任何一个类都是Object类的子类，Object类是所有Java类的总父类
// Object类中的方法任何一个Java类都有
public class Pet {
    private String name;
    private int age;
    private String type;

    public Pet() {
    }

    public Pet(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo(){
        return "名字："+name+"，年龄："+age+"，品种："+type;
    }

    public Pet play(){
        System.out.println("和主人玩耍");
        return null;
    }
}
