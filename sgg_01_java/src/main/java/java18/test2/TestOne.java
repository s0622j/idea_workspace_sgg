package java18.test2;

import java.util.*;

public class TestOne {
    public static void main(String[] args) {
        // 泛型的集合
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Mary");
        list.add("June");

        String name = list.get(0);

        // 如果向使用迭代器，则要求迭代器也必须泛型，迭代器的泛型必须和集合的泛型一致
        Iterator<String> iter = list.iterator();

        while(iter.hasNext()){
            String s = iter.next();
        }

        Set<String> set = new HashSet<>();
        set.add("Tom");

        Map<String,String> map = new HashMap<>();
        map.put("班长","Tom");
        String value = map.get("班长");
        System.out.println(value);
    }
}
