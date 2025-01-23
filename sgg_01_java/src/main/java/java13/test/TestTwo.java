package java13.test;

public class TestTwo {
    public static void main(String[] args) {
        MyThreadTwo myThreadTwo = new MyThreadTwo();
        Thread thread = new Thread(myThreadTwo);
        thread.start();// 开启子线程，调用参数对象的run方法
        new Thread(myThreadTwo).start();
        new Thread(myThreadTwo).start();
        for (int i = 0; i < 100; i++) {
            System.out.println(i+"=================================");
        }
    }
}
