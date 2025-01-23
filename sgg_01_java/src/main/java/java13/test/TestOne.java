package java13.test;

public class TestOne {
    public static void main(String[] args) {
        // methodOne();
        MyThreadOne myThreadOne = new MyThreadOne();
        myThreadOne.setName("子线程1");
        myThreadOne.setPriority(Thread.MIN_PRIORITY);
        System.out.println(myThreadOne.getPriority());
        System.out.println(myThreadOne.isAlive()+"************");
        // 一个线程对象只能开启一个子线程
        myThreadOne.start();// 开启子线程，调用run方法。
        System.out.println(myThreadOne.isAlive()+"!!!!!!!!!!!!");
        MyThreadOne myThreadOne1 = new MyThreadOne();
        myThreadOne1.setPriority(Thread.MAX_PRIORITY);
        System.out.println(myThreadOne1.getPriority());
        myThreadOne1.setName("子线程2");
        myThreadOne1.start();
        new MyThreadOne("子线程3").start();
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getPriority());
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i+"=================================");
        }
    }

    public static void methodOne(){
        for (int i = 0; i < 100; i++) {
            System.out.println(i+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}
