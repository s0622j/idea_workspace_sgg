package com.atguigu.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/*
    通过代码操作HDFS：
    1.创建连接对象
    2.具体的操作 ：上传，下载，删除,......
    3.关闭资源
 */
public class HDFSDemo {
    private FileSystem fs;
    /*
        在执行单元测试方法前执行
         1.创建连接对象
     */
    @Before
    public void before() throws URISyntaxException, IOException, InterruptedException {
        //System.out.println("===before====");
        /*
        get(final URI uri, final Configuration conf,final String user)
        uri : HDFS的地址（NameNode的地址）
        conf : 用来设置参数
        user : 操作HDFS的用户名
         */
        URI uri = new URI("hdfs://hadoop102:8020");
        Configuration conf = new Configuration();
        fs = FileSystem.get(uri, conf, "atguigu");
    }
    /*
        在单元测试方法执行后执行
        3.关闭资源
     */
    @After
    public void after(){
        if (fs != null) {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        上传
     */
    @Test
    public void test() throws IOException {
        /*
        copyFromLocalFile(boolean delSrc, boolean overwrite,Path src, Path dst)
        delSrc : 是否删除源文件（剪切还是复制）
        overwrite ：如果目标文件已经存在是否覆盖。
               true : 表示覆盖
               false : 不覆盖但是如果目标文件存在则报错。
        src ：源文件路径（本地--在这是windows）
        dst : 目标文件路径（HDFS）
         */
        fs.copyFromLocalFile(false,true,
                new Path("D:\\app_airport.sql"),
                new Path("/input01"));
    }
    /*
        下载

     */
    @Test
    public void test2() throws IOException {
        /*
        copyToLocalFile(boolean delSrc, Path src, Path dst,boolean useRawLocalFileSystem)
        delSrc : 是否删除源文件（HDFS上的）
        src : 源文件路径（HDFS上的）
        dst : 目标文件路径（windows）
        useRawLocalFileSystem : 是否使用useRawLocalFileSystem文件系统
            true : 不会产生crc文件。
            false : 会产生一个crc文件
         */
        fs.copyToLocalFile(false,new Path("/input01/app_airport.sql"),
                new Path("D:\\test"),true);
    }

}
