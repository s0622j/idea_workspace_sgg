package java19.test;

import java.io.File;
import java.io.FileInputStream;

public class TestFileInputStream {
    public static void main(String[] args) {
        // 字节输入流
        try{
            File file = new File("day19\\file\\hello.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] datas = new byte[(int)(file.length())];
            fis.read(datas);// 一次读一个字节数组的内容
            String word = new String(datas);
            System.out.println(word);
//            while(true) {
//                int code = fis.read();// 一次读取一个字节，返回值是读取到的字节编码，返回-1代表没有读取到有效字符
//                if(code == -1){
//                    break;
//                }
//                char c = (char)code;
//                System.out.print(c);
//            }
            // fis.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
