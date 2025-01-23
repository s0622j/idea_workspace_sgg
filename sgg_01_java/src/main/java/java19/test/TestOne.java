package java19.test;

import java.io.File;
import java.io.IOException;

public class TestOne {
    public static void main(String[] args) {
        // 创建File类的对象
        // File对象的常用方法
        File file = new File("D:\\temp\\hello.txt");// 绝对路径
        // File file = new File("day19\\file\\hello.txt");// 相对路径
        System.out.println(file);
        System.out.println(file.exists());// 判断给出的路径上是否真的存在文件
        System.out.println(file.getName());// 返回没有路径的文件名
        System.out.println(file.getParent());// 返回文件所在的文件夹路径
        System.out.println(file.getPath());// 返回带有路径的文件名(考虑创建文件时的方式)
        System.out.println(file.getAbsolutePath());// 返回文件的绝对路径(不考虑文件的创建方式)
        System.out.println(file.getAbsoluteFile());// 返回用绝对路径创建的File对象
        try {
            System.out.println(file.getCanonicalPath());
            System.out.println(file.getCanonicalFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getParentFile());// 返回文件所在文件夹的File对象
        try {
            file.createNewFile();// 创建路径下的硬盘文件(仅能创建文件)
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.length());// 返回文件所占硬盘大小，单位是字节
        System.out.println(file.canRead());// 判断文件是否可读
        System.out.println(file.canWrite());// 判断文件是否可写
        System.out.println(file.isHidden());// 判断文件是否隐藏
        System.out.println(file.isFile());// 判断是否是文件
        System.out.println(file.isDirectory());// 判断是否是文件夹
        System.out.println(file.delete());// 删除文件或者文件夹(如果删除文件夹，必须要求文件夹为空)
        file.mkdir();// 创建硬盘文件夹，只能创建一级
        file.mkdirs();// 创建硬盘文件夹，可以创建多级
    }
}
