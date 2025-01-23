package java14.test3;

import java.util.Random;

public class TestThree {
    public static void main(String[] args) {
        int[] one = new int[16];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(one.length);
            System.out.println(index);
        }
    }
}
