package java19.morningtest;

import java.util.*;

public class TestTwo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tom");
        String value = list.get(0);

        Set<String> set = new HashSet<>();
        set.add("Tom");

        Iterator<String> iter = list.iterator();
        Iterator<String> iter1 = set.iterator();

        Map<String,String> map = new HashMap<>();
        map.put("班长","美国");
        String val = map.get("班长");
    }
}
