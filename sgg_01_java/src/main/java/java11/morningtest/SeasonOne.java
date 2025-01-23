package java11.morningtest;

// JDK1.5之前的枚举
public class SeasonOne {
    public static final SeasonOne SPRING = new SeasonOne("春");
    public static final SeasonOne SUMMER = new SeasonOne("夏");
    public static final SeasonOne AUTUMN = new SeasonOne("秋");
    public static final SeasonOne WINTER = new SeasonOne("冬");

    private String info;

    private SeasonOne(String info){
        this.info = info;
    }

    @Override
    public String toString() {
        return info;
    }
}
