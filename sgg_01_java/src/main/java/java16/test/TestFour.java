package java16.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestFour {
    public static void main(String[] args) {
        // List集合的遍历
        List list = new ArrayList();

        list.add("Tom");
        list.add("Jerry");
        list.add("Mary");
        list.add("June");

        // 增强for循环
        for(Object o : list){
            String s = (String)o;
            System.out.println(s);
        }
        System.out.println("-----------------------------------------");
        // 迭代器
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            String s = (String)iter.next();
            System.out.println(s);
        }
        System.out.println("-------------------------------------------");
        // 传统for循环
        for (int i = 0; i < list.size(); i++) {
            String s = (String)list.get(i);
            System.out.println(s);
        }

        System.out.println(list.get(0));
    }
}
