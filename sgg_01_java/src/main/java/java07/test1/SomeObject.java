package java07.test1;

public class SomeObject {
    public void methodOne(int i,int j){
        System.out.println(i+j);
    }

    public int methodTwo(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }
    // 变长参数组
    // 调用带变长参数组的方法，可以不传参，也可以有几个传几个，多个实参间用逗号分割
    // 一个方法的参数列表中，只能出现一个变长参数组
    // 变长参数组可以和普通参数一起使用，但是变长参数组必须在形参列表的最后一项
    // 普通参数在方法调用时必须给传参，变长参数组可以没有不传，也可以有几个传几个
    public int methodThree(String s,double d,int... nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }
}
