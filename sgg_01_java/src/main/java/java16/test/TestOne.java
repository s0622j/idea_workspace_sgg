package java16.test;

import java.util.ArrayList;
import java.util.Collection;

public class TestOne {
    public static void main(String[] args) {
        // Collection接口的常用方法
        Collection col = new ArrayList();
        Collection colOne = new ArrayList();
        colOne.add("小明");
        colOne.add("小强");
        System.out.println(col.size());// 当前集合中的元素数
        col.add("Tom");// 将元素添加进集合
        col.add("Jerry");
        col.add("June");
        col.add("Mary");
        col.add("Tom");
        col.add("Tom");
        // col.add("小明");
        col.add("小强");
        System.out.println(col.size());
        col.addAll(colOne);// 将参数集合中的所有元素添加进当前集合
        System.out.println(col.size());
        System.out.println(col);
        col.remove("Tom");// 将参数从集合中移除，如果参数在集合中有重复元素，只会移除第一个匹配元素
        System.out.println(col);
        // col.removeAll(colOne);// 在原集合中移除参数集合中的所有元素
        System.out.println(col);
        // col.clear();// 清空集合
        System.out.println(col.size());
        System.out.println(col.isEmpty());// 判断集合是否为空
        System.out.println(col.contains("Tom"));// 判断集合中是否包含参数元素
        col.remove("小明");
        System.out.println(col);
        System.out.println(col.containsAll(colOne));// 判断参数集合中的元素是否都包含在原集合中
    }
}
