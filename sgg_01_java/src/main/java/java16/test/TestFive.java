package java16.test;

import java.util.ArrayList;
import java.util.List;

public class TestFive {
    public static void main(String[] args) {
        // ArrayList的特点：ArrayList底层使用可变长度数组实现
        // ArrayList遍历效率高，频繁存取效率低
        List list = new ArrayList();
        // 在集合第一次调用add方法时初始化数组，初始化长度为10
        // 当元素数超过数组长度时扩容，按照原来长度的1.5倍扩容
        for (int i = 0; i < 10; i++) {
            list.add("Tom");
        }

    }
}
