package java17.morningtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestThree {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Tom");
        list.add("Jerry");
        list.add("Mary");
        list.add("June");

        // 迭代器
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            String s = (String)iter.next();
            System.out.println(s);
        }
        System.out.println("-----------------------------");
        // 增强for循环
        for(Object o : list){
            String s = (String)o;
            System.out.println(s);
        }
        System.out.println("-------------------------------");
        // 使用传统for循环
        for (int i = 0; i < list.size(); i++) {
            String s = (String)list.get(i);
            System.out.println(s);
        }
    }
}
