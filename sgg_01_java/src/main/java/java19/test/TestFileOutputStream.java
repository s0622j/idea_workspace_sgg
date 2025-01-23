package java19.test;

import java.io.File;
import java.io.FileOutputStream;

public class TestFileOutputStream {
    public static void main(String[] args) {
        try{
            File file = new File("day19\\file\\test.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            // 追加的方式输出
            // FileOutputStream fos = new FileOutputStream(file,true);
            // 覆盖的方式输出
            FileOutputStream fos = new FileOutputStream(file);
            // fos.write(98);// 一次输出一个字节
            String word = "好好学习，天天向上";
            byte[] datas = word.getBytes();
            fos.write(datas);

            // fos.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
