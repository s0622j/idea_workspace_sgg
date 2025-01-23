package java09.test;

// 单个类的加载顺序：先静态属性，再调用静态代码块，然后创建对象时，先普通属性，再调用普通代码块，最后构造器调用
public class Dog extends Pet {
    private String type = methodOne();
    public static String info = methodTwo();

    // 静态代码块
    // 静态代码块随着类的加载按照定义属性依次调用
    // 静态代码块用于为静态属性初始化
    static{
        System.out.println("in Dog static block one");
        info = "这是一只狗";
    }

    static{
        System.out.println("in Dog static block two");
    }

    // 普通代码块
    // 普通代码块在创建对象时调用，按照定义的顺序依次调用
    // 普通代码块的调用早于构造器
    {
        System.out.println("in Dog block one");
    }

    {
        System.out.println("in Dog block three");
    }

    {
        System.out.println("in Dog block two");
    }


    public Dog(){
        // 在继承状态下，子类构造器必须在第一行调用父类构造器
        // 如果子类构造器中没有显示的调用父类的构造器，则默认调用父类无参的构造器
        // super("小白",3,"公的");
        super();
        System.out.println("in Dog()");
    }

    public Dog(String type) {
        super();
        this.type = type;
    }

    public Dog(String name, int age, String gender, String type) {
        super(name, age, gender);
        this.type = type;
    }

    public Dog(String name,String info){
        this.setName(name);
        Dog.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void play() {
        // super.play();
        System.out.println("玩儿丢飞盘");
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"，品种："+type;
    }

    public String methodOne(){
        System.out.println("in Dog methodOne()");
        return "";
    }

    public static String methodTwo(){
        System.out.println("in Dog static methodTwo()");
        return "";
    }
}
