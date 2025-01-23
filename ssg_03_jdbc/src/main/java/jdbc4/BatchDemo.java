package jdbc4;

import jdbc2.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author shenjie
 * @version 1.0
 */

/*
批处理：
注意：
    1.MySQL驱动包的版本5.1.3x才支持批处理
    2.要在url后面加上参数rewriteBatchedStatements=true表示开启批处理
    jdbc:mysql://localhost:3306/myemployees?rewriteBatchedStatements=true

 */
public class BatchDemo {
    //向表中插入十万条数据
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into student(id,name,sid) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        //给占位符赋值和执行sql
        for (int i = 1; i <= 100010; i++) {
            ps.setInt(1, i);
            ps.setString(2, "aa" + i);
            ps.setInt(3, 100 + i);
            //ps.executeUpdate();
            //添加批处理
            ps.addBatch();
            if (i % 1000 == 0 || i == 100010){
                //执行批处理
                ps.executeBatch();
                //清空批处理
                ps.clearBatch();
            }

        }


        JDBCUtils.close(connection,ps);
    }
}
