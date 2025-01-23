package java11.test1;

public class TestMyInterOne {
    public static void main(String[] args) {
        // 匿名内部类的作用是作为接口的实现类或者抽象父类的子类
        // 匿名内部类有名对象调用方法
        MyInterOne myInterOne = new MyInterOne(){
            @Override
            public void methodOne() {
                System.out.println("in unknown methodOne()");
            }
        };
        myInterOne.methodOne();
        System.out.println("--------------------------------------------");
        // 匿名内部类匿名对象调用方法
        new MyInterOne(){
            @Override
            public void methodOne() {
                System.out.println("in unknown methodOne1()");
            }
        }.methodOne();
        System.out.println("-----------------------------------------------");
        // 匿名内部类有名对象传参
        MyInterOne myInterOne1 = new MyInterOne() {
            @Override
            public void methodOne() {
                System.out.println("in unknown methodOne2()");
            }
        };
        test(myInterOne1);
        System.out.println("--------------------------------------------------");
        // 匿名内部类匿名对象传参
        test(new MyInterOne(){
            @Override
            public void methodOne() {
                System.out.println("in unknown methodOne3()");
            }
        });
    }

    public static void test(MyInterOne myInterOne){
        myInterOne.methodOne();
    }
}
