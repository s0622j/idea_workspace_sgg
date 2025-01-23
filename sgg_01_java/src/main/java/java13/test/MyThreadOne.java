package java13.test;

// 继承线程父类
public class MyThreadOne extends Thread {
    public MyThreadOne(){

    }

    public MyThreadOne(String info){
        super(info);
    }
    // 重写run方法
    @Override
    public void run() {
        // 开启子线程后，会执行run方法中的代码
        for(int i = 0;i < 100; i++){
            // getName()返回当前线程的线程名
            System.out.println(this.getName()+":"+i+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}
