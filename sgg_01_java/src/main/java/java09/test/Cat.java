package java09.test;

public class Cat extends Pet {
    private String color;

    public Cat() {
        super();
    }

    public Cat(String name, int age, String gender, String color) {
        super(name, age, gender);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void play() {
        System.out.println("玩儿毛线球");
    }
}
