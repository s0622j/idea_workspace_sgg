package java10.test1;

public class TestWork {
    public static void main(String[] args) {
        Work work = new Work("小强",27,"男");
        Work work1 = new Work("小明",27,"男");

        System.out.println(work.compareTo(work1));
        System.out.println(work.equals(work1));
    }
}
