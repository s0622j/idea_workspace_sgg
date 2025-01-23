package java11.test;

public class TestOne {
    public static void main(String[] args) {
        Season season = Season.WINTER;
        System.out.println(season);// Enum类替自定义枚举类重写了toString

        System.out.println(season.name());
        System.out.println(season.ordinal());
        System.out.println("--------------------------------------------------");
        Season[] seasons = Season.values();// 返回枚举类中所有的枚举值数组
        for (int i = 0; i < seasons.length; i++) {
            System.out.println(seasons[i]);
        }

        Season season1 = Season.valueOf("SPRING");// 根据属性名返回枚举对象
        System.out.println(season1);


    }
}
