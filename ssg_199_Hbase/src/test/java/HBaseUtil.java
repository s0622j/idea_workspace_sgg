import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class HBaseUtil {
    private Connection connection;

    {
        try {
            connection = ConnectionFactory.createConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConn() throws IOException {
        if (connection != null) {
            connection.close();
        }
    }

    //获取Table对象
    public Table getTable(String tableName) throws IOException {

        // isBlank 判断一个字符串是否是  null,"","回车,空格白字符"
        if (StringUtils.isBlank(tableName)) {

            throw new RuntimeException("表名非法!");
        }
        Table table = connection.getTable(TableName.valueOf(tableName));
        return table;
    }

    /**
     * 定义Put对象:
     * 定义一个返回Put对象的方法
     * Put对象封装了要操作的Cell
     * Put  表名，rowkey，列族名，列名，value
     */
    public Put createPut(String rowkey, String cf, String cq, String value) {

        Put put = new Put(Bytes.toBytes(rowkey));
        // java语法糖   A.() return A
        return put.addColumn(Bytes.toBytes(cf), Bytes.toBytes(cq), Bytes.toBytes(value));
    }


    @Test
    public void testgetTable() throws IOException {
        HBaseUtil hbu = new HBaseUtil();
        Table table = hbu.getTable("student");
        System.out.println("===============================table:" + table);
    }


    /**
     * create 't1','f1'
     * create 't2', {NAME => 'f1', TTL => 60}    设置一分钟后清除数据
     * scan 't1'
     * Put  t1，a3，f1，name，jack
     * Put  t1，a3，f1，age，20
     * Put  t1，a3，f1，gender，male
     */
    @Test
    public void testPut() throws IOException {
        HBaseUtil hbu = new HBaseUtil();
        //有一张表
        Table table = hbu.getTable("t2");
        //put一次就调用表的一次put方法，或也可以批量操作
        ArrayList<Put> puts = new ArrayList<>();
        puts.add(hbu.createPut("a3", "f1", "name", "jack"));
        puts.add(hbu.createPut("a3", "f1", "age", "20"));
        puts.add(hbu.createPut("a3", "f1", "gender", "male"));
        puts.add(hbu.createPut("a1", "f1", "gender", "male"));
        puts.add(hbu.createPut("a1", "f1", "age", "11"));
        //批量插入多个cell
        table.put(puts);
        table.close();
    }

    @Test
    public void testGet() throws IOException {
        HBaseUtil hbu = new HBaseUtil();
        // 有一张表
        Table table = hbu.getTable("t1");
        //封装一个Get对象，代表一次Get操作
        Get get = new Get(Bytes.toBytes("a3"));
        // 一行查询的结果
        Result result = table.get(get);
        hbu.parseResult(result);
        table.close();
    }

    /**
     * 遍历Get的一行结果
     * 一行由若干列组成，每个列都有若干个cell
     */
    public void parseResult(Result result) {

        //获取一行中最原始的cell
        Cell[] cells = result.rawCells();
        //遍历
        for (Cell cell : cells) {
            System.out.println("rowkey:" + Bytes.toString(CellUtil.cloneRow(cell)));
            System.out.println("列名:" + Bytes.toString(CellUtil.cloneFamily(cell)) + ":" + Bytes.toString(CellUtil.cloneQualifier(cell)));
            System.out.println("值:" + Bytes.toString(CellUtil.cloneValue(cell)));
        }
    }

    @Test
    public void testScan() throws IOException {
        HBaseUtil hbu = new HBaseUtil();
        //有一张表
        Table table = hbu.getTable("t1");
        //封装一个Scan对象，代表一次Scan操作
        Scan scan = new Scan();
        scan.withStartRow(Bytes.toBytes("a1"));
        scan.withStopRow(Bytes.toBytes("z1"));
        // scaner是多行查询的结果
        ResultScanner scanner = table.getScanner(scan);
        for (Result result : scanner) {
            hbu.parseResult(result);
        }
        table.close();
    }

    @Test
    public void testDelete() throws IOException {
        HBaseUtil hbu = new HBaseUtil();
        //有一张表
        Table table = hbu.getTable("t1");
        Delete delete = new Delete(Bytes.toBytes("a3"));
        // 删一列的最新版本  向指定的列添加一个cell(type=Delete,ts=最新的cell的ts)
        // delete.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("age"));
        // 删除这列的所有版本  向指定的列添加一个cell(type=DeleteColumn,ts=当前时间)
        //delete.addColumns(Bytes.toBytes("f1"), Bytes.toBytes("age"));
        // 删除列族的所有版本  向指定的行添加一个cell  f1:, timestamp=当前时间, type=DeleteFamily
        //delete.addFamily(Bytes.toBytes("f1"));
        // 删除一行的所有列族
        table.delete(delete);
        table.close();
    }


}
