package java19.test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TestOne {
    public static void main(String[] args) {
        // 转换流
        try{
            File file = new File("day19\\file\\hello.txt");
            // 创建字节节点流
            FileInputStream fis = new FileInputStream(file);
            // 创建转换流
            InputStreamReader isr = new InputStreamReader(fis);
            // 创建字符处理流
            BufferedReader br = new BufferedReader(isr);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
