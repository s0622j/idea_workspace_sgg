package java09.test;

// 先父类再子类，在静态再普通
// 先属性，再代码块，最后构造器
public class Pet {
    private String name = methodThree();
    private int age;
    private String gender;
    public static String one = methodFour();

    static {
        System.out.println("in Pet static block");
    }

    {
        System.out.println("in Pet block");
    }

    public Pet() {
        System.out.println("in Pet()");
    }

    public Pet(String name, int age, String gender) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void play(){
        System.out.println("和主人玩儿");
    }

    public String getInfo(){
        return "名字："+name+"，年龄："+age+"，性别："+gender;
    }

    public String methodThree(){
        System.out.println("in Pet methodThree()");
        return null;
    }

    public static String methodFour(){
        System.out.println("in Pet static methodFour()");
        return null;
    }
}
