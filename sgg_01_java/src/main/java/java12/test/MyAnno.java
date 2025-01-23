package java12.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义注解
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnno {
    // default声明属性的默认值
    // 如果注解中只有一个属性，且这个属性叫value则赋值时可以直接赋值不用写属性名=属性值
    public String[] value() default {"hello","nihao"};// 属性
    // public String name();
}
