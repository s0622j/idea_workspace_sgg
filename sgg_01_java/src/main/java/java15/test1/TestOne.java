package java15.test1;

public class TestOne {
    public static void main(String[] args) {
        // String创建对象时和内存结构的特点
        // 首先检索串池，看看是否已经存在了这个字符串
        // 如果串池里没有，则创建String对象
        // 如果串池中已经包含该字符串，则不会创建新的String对象，将原有串池中的对象赋值给引用
        // 在串池中，同一个String串只会存在一个对象
        String s1 = "hello";
        // String s2 = "hello";
        String s2 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
