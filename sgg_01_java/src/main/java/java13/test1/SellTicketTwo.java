package java13.test1;

public class SellTicketTwo extends Thread {
    private static int tickets = 100;
    private static Object lock = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (lock) {
                if (tickets <= 0) {
                    System.out.println("票已售完~~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + "线程卖出一张票,当前剩余票" + (--tickets) + "================");
            }
        }
    }
}
