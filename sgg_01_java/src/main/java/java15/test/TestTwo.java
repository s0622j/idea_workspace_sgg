package java15.test;

public class TestTwo {
    public static void main(String[] args) {
        // 数组按照原来长度的2倍扩容
        int[] one = {65,39,28,71,69};
        // 创建长度更长的新数组
        int[] two = new int[one.length*2];// 2倍扩容
        // 将原数组的元素赋值到新数组中
        for (int i = 0; i < one.length; i++) {
            two[i] = one[i];
        }

        for (int i = 0; i < two.length; i++) {
            System.out.println(two[i]);
        }
        System.out.println("-----------------------------------------------");
        // 增强for循环
        // 冒号左侧一定是一个变量或者一个对象，冒号右侧一定是一个数组或者是一个集合
        // 数组或者集合中的元素每次循环拿出一个给左侧的变量或者对象赋值
        for(int i : two){
            System.out.println(i);
        }
    }
}
