package java14.morningtest;

public class TestOne {
    public static void main(String[] args) {
        SellTicketOne sellTicketOne = new SellTicketOne();
        SellTicketOne sellTicketOne1 = new SellTicketOne();
        SellTicketOne sellTicketOne2 = new SellTicketOne();
        sellTicketOne.start();
        sellTicketOne1.start();
        sellTicketOne2.start();
    }
}
