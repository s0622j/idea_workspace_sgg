package java19.test1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TestFileWriter {
    public static void main(String[] args) {
        try{
            File file = new File("day19\\file\\test1.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            // 字符输出处理流(带缓冲区)
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            bufferedWriter.write("床前明月光");
            bufferedWriter.newLine();// 换行
            bufferedWriter.write("疑是地上霜");
            bufferedWriter.flush();// 清空缓冲区
            bufferedWriter.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
