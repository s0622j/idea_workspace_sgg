package java18.test;

import java.util.HashMap;
import java.util.Map;

public class TestOne {
    public static void main(String[] args) {
        // Map接口是键值对集合，每一个元素包含键和值两个对象
        // Map接口的常用方法
        Map map = new HashMap();
        map.put("班长","美国");// 将键值对元素存入集合
        map.put("学委","中国");
        map.put("体委","俄罗斯");
        map.put("文委","意大利");

        String s = (String)map.get("班长");// 用键取值
        System.out.println(s);
        System.out.println(map);
        // map.remove("班长");// 使用键作为检索条件删除键值对
        map.remove("班长","美国");// 使用键值对作为检索条件删除键值对
        System.out.println(map);
        // map.clear();// 清空集合
        System.out.println(map.isEmpty());// 判断集合是否为空
        System.out.println(map.containsKey("班长"));// 判断集合中是否存在该键
        System.out.println(map.containsValue("中国"));// 判断集合中是否存在该值
        // map.replace("学委","以色列");// 使用新值替换原键对应的值
        map.replace("学委","俄罗斯","以色列");// 以键值对为参数用新值替换原值
        System.out.println(map);
        System.out.println(map.size());
        map.put("文委","希腊");// 如果put时存入了一个集合中已经存在的键，则put方法会用新的值替换键对应的原值
        System.out.println(map.size());
        System.out.println(map);
    }
}
