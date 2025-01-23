package java14.test1;

public class TestOne {
    public static void main(String[] args) {
        // 单个生产者与单个消费者
        Stone stone = new Stone();
        Producer producer = new Producer(stone);
        Customer customer = new Customer(stone);
        producer.start();
        customer.start();
    }
}
