package java11.test2;

@SuppressWarnings("unused")
public class TestOne {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int one = 100;

        int two = 200;
        // System.out.println(one);
//        Person person = new Person();
//        person.sayHello();
//        methodOne();
    }
    // 检查方法重写是否符合语法规范
    @Override
    public String toString() {
        return "";
    }

    // 标注方法已过期
//    @Deprecated
//    public static void methodOne(){
//    }
}
