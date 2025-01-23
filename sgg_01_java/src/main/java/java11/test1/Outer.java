package java11.test1;

public class Outer {
    private int three;
    private static int four;

    // 一个类声明在另一个类的类体中，里面的这个类叫内部类
    // 成员内部类：普通成员内部类
    public class Inner{
        // 普通成员内部类只能声明普通的成员，不能声明静态的成员
        // 普通成员内部类可以访问外部类的所有成员
        private int one;
        // private static int two;

        public void methodThree(){
            System.out.println(one);
            System.out.println(three);
            System.out.println(four);
        }

//        public static void methodFour(){
//
//        }
    }

    // 成员内部类：静态成员内部类
    public static class Inner1{
        // 静态成员内部类可以声明静态成员和普通成员
        // 静态成员内部类只能访问外部类的静态成员，不能访问外部类的普通成员
        private int one;
        private static int two;

        public void methodThree(){
            System.out.println(one);
            System.out.println(two);
            // System.out.println(three);
            System.out.println(four);
        }

        public static void methodFour(){
            // System.out.println(one);
            System.out.println(two);
            // System.out.println(three);
            System.out.println(four);
        }
    }

    public void methodOne(){
        Inner inner = new Inner();

        Inner1 inner1 = new Inner1();

        int five = 0;

        // 局部内部类
        class Inner2{
            // 局部内部类只能声明普通成员，不能声明静态成员
            private int one;
//            private static int two;

            public void methodThree(){
                int six = 0;
                System.out.println(one);
                System.out.println(three);
                System.out.println(four);
                System.out.println(five);
                System.out.println(six);
            }

//            public static void methodFour(){
//
//            }
        }

        Inner2 inner2 = new Inner2();
    }

    public static void methodTwo(){
        // 在外部类类体内创建内部类对象
        Inner1 inner1 = new Inner1();
    }

}
