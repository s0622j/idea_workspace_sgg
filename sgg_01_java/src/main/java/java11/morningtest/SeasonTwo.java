package java11.morningtest;

// JDK1.5之后的枚举
public enum SeasonTwo {
    SPRING("春"),SUMMER("夏"),AUTUMN("秋"),WINTER("冬");

    private String info;

    private SeasonTwo(String info){
        this.info = info;
    }


    @Override
    public String toString() {
        return info;
    }
}
