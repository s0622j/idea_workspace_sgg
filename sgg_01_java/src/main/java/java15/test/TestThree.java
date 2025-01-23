package java15.test;

public class TestThree {
    public static void main(String[] args) {
        // 数组删除元素
        int[] one = {65,39,28,71,69,0,0,0};
        int index1 = 20;// 要移除的元素下标
        int index2 = -1;// 第一个空位下标
        // 查找第一个空位下标
        for (int i = 0; i < one.length; i++) {
            if(one[i] == 0){
                index2 = i;
                break;
            }
        }
        // 移除数组中的元素
        for(int i = index1;i < index2; i++){
           one[i] = one[i+1];
        }
        // 遍历删除元素后的数组
        for(int i : one){
            System.out.println(i);
        }
    }
}
