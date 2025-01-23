package java13.test1;

public class TestSellTicketsOne {
    public static void main(String[] args) {
        SellTicketOne stt = new SellTicketOne();
        SellTicketOne stt1 = new SellTicketOne();
        SellTicketOne stt2 = new SellTicketOne();
        stt.start();
        stt1.start();
        stt2.start();
    }
}
