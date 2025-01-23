package jdbc3;

import jdbc2.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*

事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态。
案例 ：AA给CC转账1000元
       try{
	       事务开启
	       AA减去1000元的操作;
	       System.out.println(1/0);
	       CC加上1000元的操作;
	       事务提交
       }catch(Exception e){
	      事务回滚;
       }finally{
          允许事务提交
       }
遇到的问题：可能会发生AA的操作成功但是CC的操作失败。
解决思路 ：将AA和CC的操作看成一个整体要么都成功要么都失败。

CREATE TABLE account(
NAME VARCHAR(20),
balance INT
);
 */
public class Account {
    public static void main(String[] args) throws SQLException {
        //获取Connection对象
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        try {
            //=======开启事务--禁止自动提交========
            connection.setAutoCommit(false);

            //sql语句
            String sql = "update account set balance=? where name=?";
            //预编译
            ps = connection.prepareStatement(sql);
            //给占位符赋值
            //AA减去1000
            ps.setInt(1, 1000);
            ps.setString(2, "aa");
            ps.executeUpdate();

            //System.out.println(1 / 0);

            //CC加上1000
            ps.setInt(1, 3000);
            ps.setString(2, "cc");
            ps.executeUpdate();

            //==========事务提交
            connection.commit();
        }catch (Exception e){
            //==========事务回滚
            connection.rollback();
            //打印异常信息
            e.printStackTrace();
        }finally {
            //==========允许自动提交
            connection.setAutoCommit(true);
            //关闭资源
            JDBCUtils.close(connection,ps);
        }

    }
}










