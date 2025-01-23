package java07.test;

public class TestSomeObject {
    public static void main(String[] args) {
        SomeObject so = new SomeObject();
//        int yi = 100;
//        int er = 200;
//        System.out.println("yi = "+yi+",er = "+er);
//        so.methodOne(yi,er);
//        System.out.println("yi = "+yi+",er = "+er);
        System.out.println("--------------------------------");
        MyNumber myNum = new MyNumber();
        myNum.a = 300;
        myNum.b = 400;
        System.out.println("in main myNum.a = "+myNum.a+", myNum.b = "+myNum.b);
        so.methodTwo(myNum);
        System.out.println("in main myNum.a = "+myNum.a+", myNum.b = "+myNum.b);
    }
}
