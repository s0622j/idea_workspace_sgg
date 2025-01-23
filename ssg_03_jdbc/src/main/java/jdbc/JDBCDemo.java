package jdbc;

import org.junit.Test;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/*
    JDBC: JDBC是Java提供的一套用来操作数据库的接口

    通过Java代码操作数据库
    1.确定数据库是可以正常使用（MySQL服务是否正常开启）
    2.确定MySQL的账号和密码是正确的
    3.确定MySQL版本和Mysql驱动版本匹配
    4.在工程（module）上右键创建一个目录并将驱动包放在此目录中
    5.在jar包上右键--> add as library
 */
public class  JDBCDemo {

    /*
        方式一
     */
    @Test
    public void test() throws SQLException {
        //1.创建Driver对象
        Driver driver = new com.mysql.jdbc.Driver();//全类名 ：包含包名在内的类的全名称
        //2.调用方法--获取Connection对象（有了该对象才能操作数据库）
        /*
            connect(String url, java.util.Properties info)
            url : mysql的连接地址
                jdbc:mysql://localhost:3306/atguigu
                jdbc:mysql: 协议
                localhost ：mysql服务器的地址
                3306 ：端口号
                atguigu ：库的名字
            info : 在"map"中存放mysql的账号和密码
         */
        String s = "jdbc:mysql://localhost:3306/myemployees";
        Properties p = new Properties();
        p.setProperty("user","root");//账号。key不能随便写
        p.setProperty("password","123321");//密码。key不能随便写

        Connection connect = driver.connect(s, p);
        System.out.println(connect);
    }
    /*
        方式二 : 通过DriverManager获取Connection对象
     */
    @Test
    public void test2() throws SQLException {
        //1.创建Driver对象
        Driver driver = new com.mysql.jdbc.Driver();
        //2.将driver注册到DriverManager中
        DriverManager.registerDriver(driver);
        //3.获取Connection对象
        String url = "jdbc:mysql://localhost:3306/myemployees";
        Connection connection = DriverManager.getConnection(url, "root", "123321");
        System.out.println(connection);
    }

    /*
        方式二优化
          static {
            DriverManager.registerDriver(new Driver());
           }
     */
    @Test
    public void test3() throws Exception {
        //1.让Driver类中的静态代码块执行
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取Connection对象
        String url = "jdbc:mysql://localhost:3306/myemployees";
        Connection connection = DriverManager.getConnection(url, "root", "123321");
        System.out.println(connection);
    }

    /*
        最终版（DriverManager + 读取配置文件）
     */
    @Test
    public void test5() throws Exception {
        String className = "";
        String url = "";
        String user="";
        String password = "";
        //读取配置文件
        //1.创建Properties对象
        Properties p = new Properties();
        //2.创建流
        FileInputStream fis = new FileInputStream("jdbc.properties");
        //3.加载流--将流加载到Properties中
        p.load(fis);
        //4.通过Properties读取文件中的内容
        user = p.getProperty("user");
        password = p.getProperty("password");
        url = p.getProperty("url");
        className= p.getProperty("className");
        System.out.println(user + "====" + password + "====" + url + "===" + className);
        //5.关闭资源
        fis.close();


        //1.让Driver类中的静态代码块执行
        Class.forName(className);
        //3.获取Connection对象
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test4() throws ClassNotFoundException {
        //Class.forName("com.atguigu.jdbc.A");
        Class.forName("jdbc.A");
    }
}

class A{
    static {
        System.out.println("A的静态代码块执行了");
    }
}
