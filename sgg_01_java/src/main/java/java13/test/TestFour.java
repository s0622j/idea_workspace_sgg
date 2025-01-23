package java13.test;

public class TestFour {
    public static void main(String[] args) {
        MyThreadThree myThreadThree = new MyThreadThree();
        MyThreadFour myThreadFour = new MyThreadFour(myThreadThree);
        myThreadThree.start();
        myThreadFour.start();
    }
}

class MyThreadThree extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName()+":"+i+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}

class MyThreadFour extends Thread{
    private MyThreadThree myThreadThree;
    public MyThreadFour(MyThreadThree myThreadThree){
        this.myThreadThree = myThreadThree;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName()+":"+i+"===============================");
            if(i == 50){
                try {
                    myThreadThree.join();// 线程对象插队，优先执行，直到当前线程结束，其他线程才继续执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
