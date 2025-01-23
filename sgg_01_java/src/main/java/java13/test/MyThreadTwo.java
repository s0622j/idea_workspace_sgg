package java13.test;

// 线程类实现Runnable接口
public class MyThreadTwo implements Runnable {
    // 实现run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}
