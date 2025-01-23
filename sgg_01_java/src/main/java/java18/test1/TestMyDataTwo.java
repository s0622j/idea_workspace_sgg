package java18.test1;

import java.util.Collections;

public class TestMyDataTwo {
    public static void main(String[] args) {
        // 凡是支持泛型的位置，如果不给出泛型的具体类型，则将泛型视作Object
        MyDataTwo myDataTwo = new MyDataTwo();
        myDataTwo.setData("Hello");
        String s = (String)myDataTwo.getData();

        // 一个支持泛型的类，在创建对象时给出泛型的具体类型，则所有的泛型位置都是这个具体的类型
        MyDataTwo<String> myDataTwo1 = new MyDataTwo<String>();
        myDataTwo1.setData("Hello");
        String s1 = myDataTwo1.getData();

        MyDataTwo<Integer> myDataTwo2 = new MyDataTwo<Integer>();
        myDataTwo2.setData(100);
        Integer integer = myDataTwo2.getData();

        // 给出泛型具体类型的三种形式
        MyDataTwo<String> md = new MyDataTwo();// 不推荐
        md.setData("100");
        String s2 = md.getData();
        // 泛型的确定要求引用的泛型类型必须和对象的泛型类一致，且泛型不支持多态
        MyDataTwo<String> md1 = new MyDataTwo<String>();
        md1.setData("200");
        String s3 = md1.getData();
        MyDataTwo<String> md2 = new MyDataTwo<>();// 推荐

        MyDataTwoSub<String> myDataTwoSub = new MyDataTwoSub<>();
        myDataTwoSub.setData("hello");
        String s4 = myDataTwoSub.getData();

        MyInterOne<Integer> myInterOne = new MyInterOneImpl<>();
        myInterOne.methodOne(100);
        Integer integer1 = myInterOne.methodTwo();
        Integer integer2 = myDataTwo2.methodThree(new Integer(100));
    }
}
