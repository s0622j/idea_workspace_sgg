package java17.test;

import java.util.LinkedHashSet;
import java.util.Set;

public class TestTwo {
    public static void main(String[] args) {
        // LinkedHashSet的特点：去重，同时保持新增顺序和遍历顺序一致(有序)
        Set set = new LinkedHashSet();

        set.add("June");
        set.add("Jerry");
        set.add("Mary");
        set.add("Tom");

        for (Object o : set) {
            System.out.println(o);
        }
    }
}
