package java19.morningtest;

import java.util.*;

public class TestOne {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("班长","美国");// 存放键值对，如果键是集合中没有的，则新增，如果键已经存在，则用新值替换原值
        String value = map.get("班长");// 用键取值
        System.out.println(map.size());// 集合中的元素数
        System.out.println(map.containsKey("班长"));// 判断集合中是否包含该键
        System.out.println(map.containsValue("美国"));// 判断集合中是否包含该值
        map.remove("班长");// 使用键做条件移除键值对
        map.remove("班长","美国");// 使用键值同时做条件移除键值对
        map.replace("班长","中国");// 使用第二个参数值替换第一个参数键的原值
        map.replace("班长","美国","中国");// 使用前两个参数键值对做检索条件用第三个参数值替换原值
        System.out.println(map.isEmpty());// 判断集合是否为空
        map.clear();// 清空集合

        Set<String> keys = map.keySet();// 返回键集
        for (String key : keys) {
            String val = map.get(key);
            System.out.println(key+"="+val);
        }
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()){
            String key = iter.next();
            String val = map.get(key);
            System.out.println(key+"="+val);
        }

        Collection<String> values = map.values();// 返回值集
        for (String s : values) {
            System.out.println(s);
        }
        Iterator<String> iter1 = values.iterator();
        while(iter1.hasNext()){
            String val = iter1.next();
            System.out.println(val);
        }

        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> esn : entrySet) {
            String key = esn.getKey();
            String val = esn.getValue();
            System.out.println(key+"="+val);
        }
    }
}
