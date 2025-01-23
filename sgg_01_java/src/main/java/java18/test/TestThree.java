package java18.test;

import java.util.HashMap;
import java.util.Map;

public class TestThree {
    public static void main(String[] args) {
        // HashMap实现类的特点：第一个调用put方法时初始化数组，初始化长度为16
        // 当集合中元素数超过负载因子和数组长度乘积时扩容，按照原来的数组长度的两倍扩容
        // 在jdk1.8之后，如果一个链表元素超过8个，并且此时数组长度达到64，则将链表结构变成红黑树
        // jdk1.8之前HashMap底层使用数组+链表存储元素，jdk1.8之后HashMap底层使用数据+链表+红黑树存储
        Map map = new HashMap();

        map.put("班长","Tom");
    }
}
