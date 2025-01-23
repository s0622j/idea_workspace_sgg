package java16.test;

import java.util.ArrayList;
import java.util.List;

public class TestThree {
    public static void main(String[] args) {
        // List接口的特点：有序(新增顺序和遍历顺序一致)且允许重复元素，有下标，可以通过下标对元素进行精确操作
        // List接口的独有方法
        List list = new ArrayList();
        System.out.println(list.size());
        list.add("Tom");
        list.add("Jerry");
        list.add("Mary");
        list.add("June");
        System.out.println(list.size());
        System.out.println(list);
        list.add(1,"小明");// 将第二个参数元素新增到集合的第一个参数索引位置
        System.out.println(list);
        List list1 = new ArrayList();
        list1.add("小白");
        list1.add("小强");
        list.addAll(2,list1);
        System.out.println(list);
        list.set(1,"小黑");// 用新元素替换指定位置的原元素
        System.out.println(list);
        list.remove(1);// 移除指定下标处的元素
        System.out.println(list);
        List list2 = new ArrayList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.remove(new Integer(1));// remove方法以下标移除元素为优先
        System.out.println(list2);
        String s = (String)list.get(0);// 使用下标获取单个元素
        System.out.println(s);
    }
}
