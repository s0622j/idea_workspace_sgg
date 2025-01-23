package java15.test;

import java.util.Arrays;

public class TestOne {
    public static void main(String[] args) {
        // 数组的复制
        int[] one = {23,65,78,95,40};
        int[] two = Arrays.copyOf(one,8);
        for (int i = 0; i < two.length; i++) {
            System.out.println(two[i]);
        }
        String[] three = {"nihao","baibai","chilema"};
        String[] four = Arrays.copyOf(three,6);
        for (int i = 0; i < four.length; i++) {
            System.out.println(four[i]);
        }
    }
}
