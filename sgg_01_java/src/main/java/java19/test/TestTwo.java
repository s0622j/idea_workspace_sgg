package java19.test;

import java.io.File;

public class TestTwo {
    public static void main(String[] args) {
        File file = new File("D:\\JavaTools");
        if(file.isDirectory()){
            String[] names = file.list();// 返回一个文件夹下的所有子文件及子文件夹的名字
            for (String s : names) {
                System.out.println(s);
            }
            System.out.println("--------------------------------------------------");
            File[] files = file.listFiles();// 返回一个文件夹下的所有子文件及子文件夹的File对象
            for (File f : files) {
                System.out.println(f);
//                if(f.isDirectory()){
//                    File[] filesOne = f.listFiles();
//                    for (File f1 : filesOne) {
//                        if(f1.isDirectory()){
//                            File[] filesTwo = f1.listFiles();
//                        }
//                    }
//                }
            }
        }else{
            System.out.println("这不是一个文件夹");
        }
    }
}
