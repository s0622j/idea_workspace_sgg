package java14.test2;

public class TestOne {
    public static void main(String[] args) {
        // 多个生产者与多个消费者
        Stone stone = new Stone();
        Producer producer = new Producer(stone);
        Producer producer1 = new Producer(stone);
        Producer producer2 = new Producer(stone);
        Customer customer = new Customer(stone);
        Customer customer1 = new Customer(stone);
        Customer customer2 = new Customer(stone);
        producer.start();
        producer1.start();
        producer2.start();
        customer.start();
        customer1.start();
        customer2.start();
    }
}
