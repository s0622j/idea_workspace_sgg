package java21.test1;

public class TestOne {
    public static void main(String[] args) {
        // 获取类类对象的四种方式
        // 一个类的类类对象在方法区中只会有一个对象
        // 使用类名获取该类的类类对象
        Class classOne = Student.class;
        System.out.println(classOne.getName());// 返回类类对象代表的类的类名
        // 使用对象获取该对象所属的类的类类对象
        Student stu = new Student("Tom",20,"男");
        Class classTwo = stu.getClass();
        System.out.println(classOne == classTwo);
        // 使用String获取类类对象
        try {
          Class classThree = Class.forName("com.atguigu.test1.Student");
            System.out.println(classOne == classThree);
            System.out.println(classTwo == classThree);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 使用类加载器获取类类对象
        try {
            Class classFour = Student.class.getClassLoader().loadClass("com.atguigu.test1.Student");
            System.out.println(classOne == classFour);
            System.out.println(classTwo == classFour);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
