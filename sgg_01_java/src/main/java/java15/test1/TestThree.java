package java15.test1;

public class TestThree {
    public static void main(String[] args) {
        // String的常用方法
        String s1 = "hello world";
        int index1 = s1.indexOf('o');// 返回参数字符在原串中第一次出现的位置
        System.out.println(index1);
        int index2 = s1.indexOf('o',s1.indexOf('o')+1);// 从第二个参数索引开始搜索第一个参数字符第一次出现的位置
        System.out.println(index2);
        int index3 = s1.indexOf("lo");// 返回参数字符串在原串中第一次出现的位置
        System.out.println(index3);
        int index4 = s1.indexOf("lo",5);// 从第二个参数索引开始搜索第一个参数字符串第一次出现的位置
        System.out.println(index4);
        int index5 = s1.lastIndexOf('o');// 在原串中搜索最后一次出现参数字符的索引
        System.out.println(index5);
        int index6 = s1.lastIndexOf('o',s1.lastIndexOf('o')-1);// 从第二个参数索引位置开始搜索最后一次出现第一个参数字符的索引
        System.out.println(index6);
        int index7 = s1.lastIndexOf("o");
        System.out.println(index7);
        int index8 = s1.lastIndexOf("o",6);
        System.out.println(index8);

        String s2 = s1.substring(6);// 从参数位置开始截取到字符串末尾
        System.out.println(s2);
        String s3 = s1.substring(0,5);// 从第一个参数索引位置开始截取到第二个参数索引位置的前一位
        System.out.println(s3);
    }
}
