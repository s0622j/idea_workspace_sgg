package jdbc2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
CREATE TABLE student(
id INT,
NAME VARCHAR(20),
sid INT
);
 */
public class CRUDDemo {
    /*
        向数据库中插入一条数据
     */
    @Test
    public void test() throws SQLException {
        //1.获取Connection对象
        Connection connection = JDBCUtils.getConnection();
        //2.sql语句
        // ? : 占位符
        String sql = "insert into student(id,name,sid) values(?,?,?)";

        //3.对sql预编译
        //调用prepareStatement返回PreparedStatement对象。有了该对象就可以给占位符赋值，执行sql语句
        PreparedStatement ps = connection.prepareStatement(sql);
        //3.1.给占位符赋值
        /*
        setInt(int parameterIndex, int x)
        parameterIndex : 第几个占位符
        x : 赋值的内容
         */
        ps.setInt(1,10);
        ps.setString(2,"龙哥");
        ps.setInt(3,1000);
        //3.2.执行sql语句
        int result = ps.executeUpdate();//executeUpdate :只是用来执行增，删，改
        System.out.println("共有" +  result + "行数据受到影响");

        //4.关闭资源
        JDBCUtils.close(connection,ps);
    }

    /*
        修改数据库中的数据
     */
    @Test
    public void test2() throws SQLException {
        //1.获取Connection对象
        Connection connection = JDBCUtils.getConnection();
        //2.sql语句
        String sql = "update student set id=? where name=?";
        //3.预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //3.1给占位符赋值
        ps.setInt(1,9);
        ps.setString(2,"longge");
        //3.2执行sql语句
        ps.executeUpdate();
        //4.关闭资源
        JDBCUtils.close(connection,ps);
    }
    /*
        删除表中的数据
     */
    @Test
    public void test3() throws SQLException {
        //1.获取Connection对象
        Connection connection = JDBCUtils.getConnection();
        //2.sql语句
        String sql = "delete from student";
        //3.预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //3.1给占位符赋值
        //ps.setInt(1,9);
        //3.2执行sql语句
        ps.executeUpdate();
        //4.关闭资源
        JDBCUtils.close(connection,ps);
    }
}
