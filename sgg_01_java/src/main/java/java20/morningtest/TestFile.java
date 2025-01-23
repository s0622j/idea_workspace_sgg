package java20.morningtest;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
        // File类的常用方法
        File file = new File("");
        System.out.println(file.getName());// 返回没有路径的文件名
        System.out.println(file.getParent());// 返回文件所在的路径名
        System.out.println(file.getPath());// 返回路径名和文件名(考虑文件创建的方式)
        System.out.println(file.getParentFile());// 返回文件所在文件夹的File对象
        System.out.println(file.getAbsolutePath());// 返回路径和文件名的绝对路径(不考虑文件创建方式)
        System.out.println(file.getAbsoluteFile());// 返回路径和文件名的绝对路径创建的File对象
        try {
            System.out.println(file.getCanonicalPath());// 返回路径和文件名的绝对路径(不考虑文件创建方式)
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(file.getCanonicalFile());// 返回路径和文件名的绝对路径创建的File对象
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.isFile());// 判断是否为文件
        System.out.println(file.isDirectory());// 判断是否为文件夹
        System.out.println(file.isHidden());// 判断是否问隐藏文件
        System.out.println(file.canRead());// 判断文件是否可读
        System.out.println(file.canWrite());// 判断文件是否可写
        try {
            file.createNewFile();// 创建新文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.mkdir();// 创建新文件夹，但是只能创建最后一级
        file.mkdirs();// 创建新文件夹，可以创建多级
        file.delete();// 删除文件或者文件夹，如果删除文件夹则需要文件夹为空
        String[] files = file.list();// 返回文件夹下的所有子文件及子文件夹的名字
        File[] files1 = file.listFiles();// 返回文件夹下的所有的子文件及子文件夹的File对象
    }
}
