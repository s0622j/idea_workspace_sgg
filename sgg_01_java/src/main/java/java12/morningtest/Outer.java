package java12.morningtest;

@SuppressWarnings("unused")
public class Outer {
    private int one;
    private static int two;

    public static class Inner{
        private int three;
        private static int four;

        public void methodOne(){
            System.out.println(three);
            System.out.println(four);
            // System.out.println(one);
            System.out.println(two);
        }
    }

    public static void main(String[] args) {
        Inner inner = new Inner();
        inner.methodOne();
    }

    @Override
    @SuppressWarnings("unused")
    public String toString() {
        @SuppressWarnings("unused")
        int i = 100;
        return super.toString();
    }
}
