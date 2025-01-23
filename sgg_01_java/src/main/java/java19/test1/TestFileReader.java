package java19.test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TestFileReader {
    public static void main(String[] args) {
        try{
            File file = new File("day19\\file\\hello.txt");
            // 字符输入节点流
            FileReader fileReader = new FileReader(file);
            // 字符输入处理流(带缓冲区)
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String word = bufferedReader.readLine();
                if(word == null){
                    break;
                }
                System.out.println(word);
            }
            bufferedReader.close();
            fileReader.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
