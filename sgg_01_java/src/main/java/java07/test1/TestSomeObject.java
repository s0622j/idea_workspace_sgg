package java07.test1;

public class TestSomeObject {
    public static void main(String[] args) {
        SomeObject so = new SomeObject();
        so.methodOne(100,200);

        int[] nums = {100,200,300,400,500};
        int result = so.methodTwo(nums);
        System.out.println(result);
        // 变长参数组是为了方便调用点调用
        int result1 = so.methodThree("s",20.5,100,200,300);
        System.out.println(result1);
    }
}
