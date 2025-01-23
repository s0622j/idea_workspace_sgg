package java15.test;

public class TestFour {
    public static void main(String[] args) {
        // 指定位置新增元素
        int[] one = {65,39,28,71,69,0,0,0};
        int newNum = 101;// 新增的数值
        int index1 = 6;// 新增位置下标
        int index2 = -1;// 第一个空位下标
        // 查找第一个空位下标
        for (int i = 0; i < one.length; i++) {
            if(one[i] == 0){
                index2 = i;
                break;
            }
        }
        if(index1 >= 0 && index1 <= index2){
            // 新增下标合法
            // 向指定位置插入元素
            for(int i = index2;i > index1; i--){
                one[i] = one[i-1];
            }
            one[index1] = newNum;

            for (int i : one) {
                System.out.println(i);
            }
        }else{
            System.out.println("请输入合法的新增下标");
        }
    }
}
