package jdbc3;

//import com.alibaba.druid.util.JdbcUtils;
import jdbc2.JDBCUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/*
    DBUtils工具类 ：用来对数据库进行操作
 */
public class DBUtilsDemo {
    /*
        对表进行增，删，改的操作
     */
    @Test
    public void test() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //2.进行增，删，改的操作
        /*
            update(Connection conn, String sql, Object... params)
            conn :Connection对象
            sql : sql语句
            params : 给占位符赋值的内容
         */
        int result = queryRunner.update(JDBCUtils.getConnection(),
                "insert into student(id,name,sid) values(?,?,?)", 5, "abc", 1200);

        System.out.println("有" + result + "条数据受到影响");
    }

    /*
        查询
     */
    @Test
    public void test2() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //2.查询
        /*
        query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)
        conn :Connection对象
        sql : sql语句
        rsh ：ResultSetHandler是一个接口传入该接口的实现类。不同的实现类返回的最终结果的形式不一样
            BeanHandler:把结果集转为一个 Bean
            BeanListHandler:把结果集转为一个 Bean 的集合
        params ： 给占位符赋值的内容
         */

        /*
        Student student = queryRunner.query(JDBCUtils.getConnection(), "select id,name,sid from student where id=?",
                new BeanHandler<Student>(Student.class), 5);

        System.out.println(student);
         */
        //如果类中属性的名字和表中字段的名字不相同那么无法获取到对应的值。
        //解决办法 ：在查询时使用别名
        List<Student> students = queryRunner.query(JDBCUtils.getConnection(), "select id aid,name,sid from student",
                new BeanListHandler<Student>(Student.class));

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
