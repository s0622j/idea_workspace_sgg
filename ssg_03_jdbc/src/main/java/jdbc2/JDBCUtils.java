package jdbc2;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/*
    工具类
 */
public class JDBCUtils {
    private static String className;
    private static String url;
    private static String user;
    private static String password;

    static {
        FileInputStream fis = null;
        try {
            //读取配置文件
            //1.创建Properties对象
            Properties p = new Properties();
            //2.创建流
            fis = new FileInputStream("jdbc.properties");
            //fis = new FileInputStream("H:\\idea_workspace_sgg\\ssg_03_jdbc\\src\\main\\resources\\jdbc.properties");
            //3.加载流--将流加载到Properties中
            p.load(fis);
            //4.通过Properties读取文件中的内容
            user = p.getProperty("user");
            password = p.getProperty("password");
            url = p.getProperty("url");
            className = p.getProperty("className");
            System.out.println(user + "====" + password + "====" + url + "===" + className);
        }catch (Exception e){
            //将编译时异常转为运行时异常 ---- 终止程序的运行
            e.printStackTrace();//打印异常信息
            throw new RuntimeException(e.getMessage());//e.getMessage() :获取异常信息
        }finally {
            //5.关闭资源
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        获取Connection对象
     */
    public static Connection getConnection(){
        try {
            //1.让Driver类中的静态代码块执行
            Class.forName(className);
            //3.获取Connection对象
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }catch (Exception e){
            e.printStackTrace();
            //终止程序运行
            throw new RuntimeException(e.getMessage());
        }
    }

    /*
        关闭资源
     */
    public static void close(Connection connection, PreparedStatement ps) {
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, PreparedStatement ps, ResultSet rs) {
        close(connection,ps);
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
