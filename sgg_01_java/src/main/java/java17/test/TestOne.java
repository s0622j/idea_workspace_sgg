package java17.test;

import java.util.HashSet;
import java.util.Set;

public class TestOne {
    public static void main(String[] args) {
        // Set集合的特点：无下标，无序(新增顺序和遍历顺序不一致)，去重(不允许重复记录)
        // Set接口没有独有方法
        Set set = new HashSet();
        set.add("Jerry");
        set.add("June");
        set.add("Tom");
        set.add("Mary");
        System.out.println(set);
        set.add("Tom");
        set.add("Tom");
        set.add("Tom");
        System.out.println(set);
    }
}
