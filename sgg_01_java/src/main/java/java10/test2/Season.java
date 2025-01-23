package java10.test2;

// JDK1.5之前的枚举类
public class Season {
    // 提供若干本类属性作为公开静态常量
    public static final Season SPRING = new Season("春季");
    public static final Season SUMMER = new Season("夏季");
    public static final Season AUTUMN = new Season("秋季");
    public static final Season WINTER = new Season("冬季");

    private String info;

    // 私有所有的构造器
    private Season(){

    }

    private Season(String info){
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "这个季节是："+info;
    }
}
