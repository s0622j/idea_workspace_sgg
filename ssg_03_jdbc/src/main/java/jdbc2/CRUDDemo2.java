package jdbc2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDDemo2 {
    /*
        查询表中的数据
     */
    @Test
    public void test() throws SQLException {
        //1.获取Connection对象
        Connection connection = JDBCUtils.getConnection();
        //2.sql语句
        String sql = "select id,name,sid from student where id=?";
        //3.预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.给占位符赋值
        ps.setInt(1,3);
        //5.执行sql语句
        //ResultSet :用来遍历查询的结果
        ResultSet rs = ps.executeQuery();//executeQuery : 执行查询的语句
        //6.通过ResultSet遍历数据
        while (rs.next()){//next() :如果有数据结果为true
            //7.获取对应的字段中的数据
            //getInt(String columnLabel) :通过字段的名字获取对应的值
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int sid = rs.getInt("sid");
            System.out.println(id + " == " + name + " == " + sid);
        }
        //7.关闭资源
        JDBCUtils.close(connection,ps,rs);
    }

    /*
       查询表中的数据
    */
    @Test
    public void test2() throws SQLException {
        //1.获取Connection对象
        Connection connection = JDBCUtils.getConnection();
        //2.sql语句
        String sql = "select id,name,sid from student";
        //3.预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //5.执行sql语句
        //ResultSet :用来遍历查询的结果
        ResultSet rs = ps.executeQuery();//executeQuery : 执行查询的语句
        //6.通过ResultSet遍历数据
        while (rs.next()){//next() :如果有数据结果为true
            //7.获取对应的字段中的数据
            //getInt(String columnLabel) :通过字段的名字获取对应的值
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int sid = rs.getInt("sid");
            System.out.println(id + " == " + name + " == " + sid);
        }
        //7.关闭资源
        JDBCUtils.close(connection,ps,rs);
    }

    /*
        通过调用方法获取表中所有的数据
     */
    @Test
    public void test3() throws SQLException {
        List<Student> students = getStudents();
        //遍历集合中的数据
        for (Student student : students) {
            System.out.println(student);
        }
    }
    /*
        自定义一个方法。调用此方法就可以获取表中所有的数据
     */
    public List<Student> getStudents() throws SQLException {
        //创建一个集合用来存放对象
        List<Student> list = new ArrayList<>();

        Connection connection = JDBCUtils.getConnection();
        String sql = "select id,name,sid from student";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int sid = rs.getInt("sid");
            //封装
            Student s = new Student(id, name, sid);
            //将对象放入到集合中
            list.add(s);
        }
        JDBCUtils.close(connection,ps,rs);
        //返回集合
        return list;
    }
}
