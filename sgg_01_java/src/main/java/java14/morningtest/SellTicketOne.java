package java14.morningtest;

public class SellTicketOne extends Thread {
    private static int tickets = 100;
    private static Object lock = new Object();
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock){
                if(tickets <= 0){
                    System.out.println("票已售完~~~~~~~~~~~~~~~~~~~~");
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName()+"线程卖出一张票，当前剩余票："+(--tickets)+"张====================");
            }
        }
    }
}
