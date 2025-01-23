package java10.test3;

// JDK1.5之后的枚举
public enum Season {
    // enum声明的枚举类必须在类体的第一部分给出若干本类的属性
    SPRING("春"),
    SUMMER("夏"),
    AUTUMN("秋"),
    WINTER("冬");

    private String info;

    // enum关键字声明的枚举类所有的构造器默认私有，也只能使用私有
    private Season(String info){
        this.info = info;
    }

    @Override
    public String toString() {
        return info;
    }
}
