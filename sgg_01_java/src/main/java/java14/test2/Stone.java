package java14.test2;

public class Stone {
    private int items = 20;// 仓库库存上限为20

    // 生产商品
    public void add(){
        synchronized (this){
            while(items >= 20){
                System.out.println("库存已达上限，暂停生产先消费~~~~~~~~~~~~~~");
                try {
                    this.wait();// 当前线程进入等待状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()
                    +"生产线程生产了一个商品，当前库存数量为："
                    +(++items)+"=======================");
            this.notifyAll();// 唤醒所有处于等待的线程
        }
    }
    // 消费商品
    public void get(){
        synchronized (this){
            while(items <= 0){
                System.out.println("商品库存已空，暂停消费先生产~~~~~~~~~~~~~~~~~~~~~~~~~");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()
                    +"消费线程消费了一个商品，当前库存数量："
                    +(--items)+"====================");
            this.notifyAll();
        }
    }
}
