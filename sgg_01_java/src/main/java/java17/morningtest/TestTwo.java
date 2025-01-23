package java17.morningtest;

import java.util.ArrayList;
import java.util.List;

public class TestTwo {
    public static void main(String[] args) {
        // List接口的独有方法
        List list = new ArrayList();
        list.add("Tom");
        list.add("Jerry");
        list.add("Mary");
        list.add(1,"June");// 向指定下标处新增一个元素
        System.out.println(list);
        List list1 = new ArrayList();
        list1.add("xiaoming");
        list1.add("xiaoqiang");
        list.addAll(2,list1);// 向指定下标处新增一整个集合的所有元素
        list.set(1,"小白");// 使用新元素替换下标处的原元素
        System.out.println(list);
        list.remove(1);// 移除指定下标处的元素
        System.out.println(list);
        int index = list.indexOf("Tom");// 返回参数在集合中第一次出现的索引
        int index1 = list.lastIndexOf("Tom");// 返回参数在集合中最后一次出现的位置
        String s = (String)list.get(0);// 返回指定下标处的元素
    }
}
