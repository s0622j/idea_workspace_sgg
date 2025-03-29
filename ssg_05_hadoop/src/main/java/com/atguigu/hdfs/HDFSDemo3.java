package com.atguigu.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/*
   测试参数的优先级 ：

   参数的配置 ： 客户端代码,客户端的配置文件,服务器端xxx-default.xml，服务器端的xxx-site.xml

   在客户端的执行的命令 ： 客户端代码 > 客户端的配置文件 > 服务器端的xxx-default.xml

================================

   在服务器端执行命令 : hadoop fs -put a.txt /demo
                    服务器端xxx-site.xml > 服务器端xxx-default.xml

 */
public class HDFSDemo3 {
    public static void main(String[] args) throws IOException {
        //1.创建客户端对象
        Configuration conf = new Configuration();
        //设置NameNode的地址
        conf.set("fs.defaultFS","hdfs://hadoop102:8020");
        //设置副本数
        //conf.set("dfs.replication","5");
        FileSystem fs = FileSystem.get(conf);

        //2.具体操作
        fs.copyFromLocalFile(false,true,
                new Path("D:\\io\\hdfs\\longge.txt"),
                new Path("/demo"));

        //3.关闭资源
        fs.close();
    }
}
