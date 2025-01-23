package java16.test;

import java.util.LinkedList;

public class TestSix {
    public static void main(String[] args) {
        // LinkedList底层使用双向链表实现
        // LinkedList有一套对首尾元素单独操作的方法
        // LinkedList遍历效率低，频繁存取效率高
        LinkedList list = new LinkedList();
        list.add("小明");
        list.addFirst("Tom");
        list.addLast("Jerry");
        list.getFirst();
        list.getLast();
        list.removeFirst();
        list.removeLast();
    }
}
