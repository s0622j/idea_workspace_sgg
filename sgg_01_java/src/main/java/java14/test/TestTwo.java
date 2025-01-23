package java14.test;

public class TestTwo {
    public static void main(String[] args) {
        SellTicketTwo sellTicketTwo = new SellTicketTwo();
        Thread thread = new Thread(sellTicketTwo);
        thread.start();
        Thread thread1 = new Thread(sellTicketTwo);
        thread1.start();
        Thread thread2 = new Thread(sellTicketTwo);
        thread2.start();
    }
}
