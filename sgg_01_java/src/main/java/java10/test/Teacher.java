package java10.test;

// abstract关键字是抽象关键字，修饰类，类叫做抽象类，修饰方法，方法叫做抽象方法
// 抽象的方法必须在抽象的类中，抽象的类中不仅有抽象的方法，还可以有普通的方法
// 抽象方法没有方法体，抽象的类不能实例化
public abstract class Teacher {
    private String name;
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public abstract void jiangKe();
}
