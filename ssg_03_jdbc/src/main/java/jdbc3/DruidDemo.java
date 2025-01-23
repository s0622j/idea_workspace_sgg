package jdbc3;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
    数据库连接池 ：Druid
 */
public class DruidDemo {
    /*
        方式一 ：
     */
    @Test
    public void test() throws SQLException {
        //1.创建数据库连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        //2.给属性赋值
        dataSource.setUsername("root");//mysql账号
        dataSource.setPassword("root");//mysql密码
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");//Driver类的全类名
        dataSource.setUrl("jdbc:mysql://localhost:3306/myemployees");
        //3.获取Connection对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //4.关闭资源
        connection.close();
    }

    /*
        方式二
     */
    @Test
    public void test2() throws Exception {
        Properties p = new Properties();//创建Properties对象
        FileInputStream fis = new FileInputStream("druid.properties");//创建输入流
        p.load(fis);//加载流

        //1.创建数据库连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(p);
        //2.获取数据库连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //3.关闭
        connection.close();
    }
}
