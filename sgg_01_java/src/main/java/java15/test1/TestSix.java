package java15.test1;

public class TestSix {
    public static void main(String[] args) {
        // StringBuilder和StringBuffer
        String word = "Hello";
        StringBuilder stringBuilder = new StringBuilder(word);
        stringBuilder.append(" World").append("\n").append("One");
        stringBuilder.append(" ").append("World").append(" ").append("One");
        stringBuilder.append(" ").append("Dream");
        word = stringBuilder.toString();
        System.out.println(word);
    }
}
