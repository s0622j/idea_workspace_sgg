package java14.test3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class TestTwo {
    public static void main(String[] args) {
        BigInteger b1 = new BigInteger("892034980529802958324098");
        BigInteger b2 = new BigInteger("789832409805923094283098");
        System.out.println(b1.add(b2));
        System.out.println(b1.subtract(b2));
        System.out.println(b1.multiply(b2));
        System.out.println(b1.divide(b2));
        System.out.println(b1.remainder(b2));
        System.out.println("------------------------------------------------");
        BigDecimal b3 = new BigDecimal("980809480298485.578749587");
        BigDecimal b4 = new BigDecimal("7987482794728492.87897984");
        System.out.println(b3.add(b4));
        System.out.println(b3.subtract(b4));
        System.out.println(b3.multiply(b4));
        System.out.println(b3.divide(b4, RoundingMode.DOWN));
        System.out.println(b3.remainder(b4));
    }
}
