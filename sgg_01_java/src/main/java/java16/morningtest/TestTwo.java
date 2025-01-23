package java16.morningtest;

public class TestTwo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append(" World").append("\n");
        stringBuilder.append("One World").append(" ").append("One");
        stringBuilder.append(" Dream");
        String word = stringBuilder.toString();
        System.out.println(word);
    }
}
