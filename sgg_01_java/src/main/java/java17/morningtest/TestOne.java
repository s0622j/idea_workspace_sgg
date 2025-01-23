package java17.morningtest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestOne {
    public static void main(String[] args) {
        // Collection的常用方法
        Collection col = new ArrayList();
        col.add("Tom");// 将元素添加进集合
        Collection col1 = new ArrayList();
        col1.add("Jerry");
        col1.add("June");
        col.addAll(col1);// 将参数集合中所有的元素添加进当前集合
        col.size();// 表示当前集合中的元素数
        col.isEmpty();// 判断集合是否为空
        col.remove("Tom");// 从集合中移除参数元素
        col.removeAll(col1);// 从原集合中移除参数集合中所有的元素
        col.clear();
        col.contains("Tom");// 判断参数元素是否存在于集合中
        col.containsAll(col1);// 判断参数集合中的所有元素是否都存在于原集合中
        Object[] objs = col.toArray();// 将集合中元素变成数组保存
        Iterator iter = col.iterator();// 返回用于遍历当前集合的迭代器对象
    }
}
