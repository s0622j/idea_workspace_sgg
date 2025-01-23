package jdbc;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

/*
    Properties:
    1.Properties是Hashtable的子类。
    2.Properties中的key,value默认是String类型。
    3.常用Properteis读取配置文件
 */
public class PropertiesDemo {
    /*
        读取配置文件
        注意：在module中 如果是单元测试方法那么相对路径是当前module下
                       如果是main方法那么相对路径是当前工程下
     */
    @Test
    public void test() throws Exception {
        //1.创建Properties对象
        Properties p = new Properties();
        //2.创建流
        FileInputStream fis = new FileInputStream("jdbc.properties");
        //3.加载流--将流加载到Properties中
        p.load(fis);
        //4.通过Properties读取文件中的内容
        String user = p.getProperty("user");
        String password = p.getProperty("password");
        System.out.println(user + "====" + password);
        //5.关闭资源
        fis.close();
    }
}
