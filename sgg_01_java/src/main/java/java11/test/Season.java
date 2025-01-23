package java11.test;

// JDK1.5之后的枚举
// enum关键字声明的枚举类默认继承自Enum类
public enum Season{
    SPRING("春"),SUMMER("夏"),AUTUMN("秋"),WINTER("冬");

    private String info;

    private Season(String info){
        this.info = info;
    }


//    @Override
//    public String toString() {
//        return info;
//    }
}
