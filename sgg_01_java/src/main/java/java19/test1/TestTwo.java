package java19.test1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class TestTwo {
    public static void main(String[] args) {
        // 转换流
        try{
            File file = new File("day19\\file\\hello.txt");
            BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
