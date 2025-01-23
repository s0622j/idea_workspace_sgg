package java12.morningtest;


public class TestFly {
    public static void main(String[] args) {
        // 匿名内部类有名对象调用方法
        Fly fly = new Fly() {
            @Override
            public void flying() {
                System.out.println("in fly one");
            }
        };
        fly.flying();
        System.out.println("--------------------------------------");
        // 匿名内部类匿名对象
        new Fly(){
            @Override
            public void flying() {
                System.out.println("in fly two");
            }
        }.flying();
        System.out.println("------------------------------------------------------");
        // 匿名内部类有名对象传参
        Fly fly1 = new Fly(){
            @Override
            public void flying() {
                System.out.println("in fly three");
            }
        };
        test(fly1);
//        RunFly rf = new RunFly();
//        rf.runFly(fly1);
//        RunFly.test(fly1);
        System.out.println("--------------------------------------------");
        // 匿名内部类匿名对象传参
        test(new Fly(){
            @Override
            public void flying() {
                System.out.println("in fly four");
            }
        });
    }

    public static void test(Fly fly){
        fly.flying();
    }

}

interface Fly{
    public void flying();
}

class RunFly{
    public void runFly(Fly fly){
        fly.flying();
    }

    public static void test(Fly fly){
        fly.flying();
    }
}
