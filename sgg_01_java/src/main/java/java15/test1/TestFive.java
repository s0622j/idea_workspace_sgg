package java15.test1;

public class TestFive {
    public static void main(String[] args) {
        // 正则表达式匹配
        String s1 = "Oorld";
        String s2 = "[W,H,K][a-z,A-Z]{4}";
        boolean flag = s1.matches(s2);
        System.out.println(flag);
    }
}
