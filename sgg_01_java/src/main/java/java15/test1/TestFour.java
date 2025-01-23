package java15.test1;

public class TestFour {
    public static void main(String[] args) {
        // String的常用方法
        String s1 = "hellor world";
        String s2 = s1.replace('o','x');// 从原串中用第二个参数字符替换所有的第一个参数字符
        System.out.println(s2);
        String s3 = s1.replaceAll("or","xyz");// 从原串中用第二个参数字符串替换所有的第一个参数字符串
        System.out.println(s3);
        String s4 = s1.replaceFirst("or","xyz");// 从原串中用第二个参数替换第一次出现的第一个参数字符串
        System.out.println(s4);
        String s5 = "One|world|One|Dream";
        String[] ss = s5.split("\\|");// 使用参数作为分割符，将原串分割成字符串数组
        System.out.println(ss.length);
        for (String s : ss) {
            System.out.println(s);
        }
    }
}
