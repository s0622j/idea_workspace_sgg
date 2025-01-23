package java15.morningtest;

import java.util.Random;

public class TestThree {
    public static void main(String[] args) {
        int[] nums = new int[16];
        for (int i = 0; i < 10; i++) {
            int index = (int)(Math.random()*nums.length);
            System.out.println(index);
        }
        System.out.println("---------------------------------");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(nums.length);
            System.out.println(index);
        }
    }
}
