package com.atguigu.hdfs;

import java.util.Arrays;

public class MainTest {
    /*
        给main方法传参 ：
            1.在IDEA中传参 --  在运行按钮上右键--->点击Edit 类名.main() --->
                    Program Arguments后面写传的参数 --->默认就是字符串 多个参数之间用空格隔开

            2. java 字节码文件名  参数1 参数2 .......
            */
    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(Arrays.toString(args));
        System.out.println("在运行按钮上右键--->点击Edit 类名.main() --->sas");
    }
}
