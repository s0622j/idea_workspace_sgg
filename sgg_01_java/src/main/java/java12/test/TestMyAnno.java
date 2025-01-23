package java12.test;

@MyAnno({"hello","nihao","byebye"})
public class TestMyAnno {
    @MyAnno(value = "hello")
    private int one;
    // @MyAnno
    public TestMyAnno(){

    }
    @MyAnno("hello")
    public void methodOne(){

    }
}
