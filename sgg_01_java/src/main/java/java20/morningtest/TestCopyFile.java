package java20.morningtest;

import java.io.*;

public class TestCopyFile {
    public static void main(String[] args) {
        try{
            File fileOne = new File("day20\\file\\尚硅谷_张锐_JavaSE_第15章 网络编程.md");
            File fileTwo = new File("day20\\file\\尚硅谷_张锐_JavaSE_第15章 网络编程(副本).md");
            if(!fileTwo.exists()){
                fileTwo.createNewFile();
            }
            FileInputStream fis = new FileInputStream(fileOne);
            BufferedInputStream bis = new BufferedInputStream(fis);

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileTwo));

            byte[] datas = new byte[1024];

            while(true){
                int length = bis.read(datas);
                if(length == -1){
                    break;
                }
                bos.write(datas);
                bos.flush();
            }

            bos.close();
            bis.close();
            fis.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
