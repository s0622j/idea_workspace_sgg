package java19.test1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestObjectOutputStream {
    public static void main(String[] args) {
        // 对象流
        try{
            File file = new File("day19\\file\\object.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            Student stu = new Student("Tom",20);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(stu);
            objectOutputStream.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
