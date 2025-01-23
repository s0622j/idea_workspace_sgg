package java18.test;

import java.util.*;

public class TestTwo {
    public static void main(String[] args) {
        // Map接口的遍历
        Map map = new HashMap();
        map.put("班长","美国");// 将键值对元素存入集合
        map.put("学委","中国");
        map.put("体委","俄罗斯");
        map.put("文委","意大利");

        Set keys = map.keySet();// 返回键集
        Iterator iter = keys.iterator();
        while(iter.hasNext()){
            String key = (String)iter.next();
            String value = (String)map.get(key);
            System.out.println(key+"="+value);
        }

        Collection value = map.values();// 获取值集
        Iterator iter1 = value.iterator();
        while(iter1.hasNext()){
            String val = (String)iter1.next();
            System.out.println(val);
        }

        Set set1 = map.entrySet();// 获取键值对集
        Iterator iter2 = set1.iterator();
        while(iter2.hasNext()){
            Map.Entry entry = (Map.Entry)iter2.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
