package java16.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestTwo {
    public static void main(String[] args) {
        // Collection接口的遍历
        Collection col = new ArrayList();
        col.add("Tom");
        col.add("Jerry");
        col.add("Mary");
        col.add("June");
        // 增强for循环遍历集合时底层使用的是迭代器
        for(Object o : col){
            String s = (String)o;
            System.out.println(s);
        }
        System.out.println("---------------------------------------");
        // 迭代器
        Iterator iter = col.iterator();// 返回一个迭代器对象
        while(iter.hasNext()){// 判断是否存在下一个元素
            String s = (String)iter.next();
            System.out.println(s);
        }

//        System.out.println(iter.next());// 每次只会返回一个元素
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//        System.out.println(iter.next());
    }
}
