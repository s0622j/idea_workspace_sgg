package java14.test3;

public class TestOne {
    public static void main(String[] args) {
        // Math类的常用方法
        System.out.println(Math.abs(5));
        System.out.println(Math.abs(-5));

        System.out.println(Math.ceil(5.7));// 向上取整
        System.out.println(Math.ceil(5.1));
        System.out.println(Math.ceil(-5.7));
        System.out.println(Math.ceil(-5.1));

        System.out.println(Math.floor(5.7));// 向下取整
        System.out.println(Math.floor(5.1));
        System.out.println(Math.floor(-5.7));
        System.out.println(Math.floor(-5.1));

        System.out.println(Math.round(5.7));// 四舍五入
        System.out.println(Math.round(5.1));
        System.out.println("-------------------------------------");
        int[] one = new int[16];
        for (int i = 0; i < 10; i++) {
            int d = (int)(Math.random()*one.length);
            System.out.println(d);
        }
    }
}
