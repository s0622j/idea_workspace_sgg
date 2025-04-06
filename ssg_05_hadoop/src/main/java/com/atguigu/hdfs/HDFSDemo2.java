package com.atguigu.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/*
    创建客户端对象方式二

    错误： Permission denied: user=wangfeilong, access=WRITE, inode="/demo":atguigu:supergroup:drwxr-xr-x
    解决方案 ：①修改权限--不建议   ②修改操作HDFS的用户名（默认是windows系统登录的用户名）

    修改用户名:在IDEA中传参 --  在运行按钮上右键--->点击Edit 类名.main() --->
                    VM OPtions ： -DHADOOP_USER_NAME=atguigu
 */
public class HDFSDemo2 {
    public static void main(String[] args) throws IOException {
        //1.创建客户端对象
        Configuration conf = new Configuration();
        //设置NameNode的地址
        conf.set("fs.defaultFS","hdfs://hadoop102:8020");
        FileSystem fs = FileSystem.get(conf);

        //2.具体操作
        fs.copyFromLocalFile(false,true,
                new Path("D:\\test\\t_app_delay_sign_currentday_push-20250324.csv"),
                new Path("/input"));

        //3.关闭资源
        fs.close();
    }
}
