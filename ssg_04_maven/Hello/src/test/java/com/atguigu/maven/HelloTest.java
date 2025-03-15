package com.atguigu.maven;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloTest {

    /*
        测试Hello中的sayHello方法
     */
    @Test
    public void testHello(){
        Hello hello = new Hello();
        //返回的内容 Hello atguigu!
        String results = hello.sayHello("atguigu");
        System.out.println("longge==================================判断结果和你预想的结果是否相同");
        //断言(判断) 判断结果和你预想的结果是否相同
        assertEquals("Hello atguigu!",results);
    }


    /*
        4.0版本之前都不支持直接运行单元测试方法。
     */
    @Test
    public void test2(){
        System.out.println("hello");
    }

}
