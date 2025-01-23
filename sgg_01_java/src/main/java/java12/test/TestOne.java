package java12.test;

import org.junit.*;

public class TestOne {

    @BeforeClass
    public static void staticBefore(){
        System.out.println("in static before()");
    }
    @AfterClass
    public static void staticAfter(){
        System.out.println("in static after()");
    }

    @Before
    public void before(){
        System.out.println("in before()");
    }
    @After
    public void after(){
        System.out.println("in after()");
    }

    @Test
    public void test(){
        System.out.println("in test()");
    }
    @Test
    public void test1(){
        System.out.println("in test1()");
    }

}
