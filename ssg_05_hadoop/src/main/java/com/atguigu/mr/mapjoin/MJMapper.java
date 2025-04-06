package com.atguigu.mr.mapjoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class MJMapper extends Mapper<LongWritable, Text,Text, NullWritable> {
    private Text outKey = new Text();//创建的key的对象
    private Map<String,String> map = new HashMap<>();//用来缓存pd.txt中的内容
    /*
        缓存pd.txt中的数据
        该方法在任务开始的时候只执行一次。在map方法执行前执行。
        作用 ：初始化
     */
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        FileSystem fs = null;
        FSDataInputStream fis = null;
        try {
            //1.创建客户端对象（为了创建流）
            fs = FileSystem.get(context.getConfiguration());
            //2.创建流
            //2.1获取缓存文件的路径
            URI[] cacheFiles = context.getCacheFiles();
            URI uri = cacheFiles[0];
            //2.2创建流
            fis = fs.open(new Path(uri));
            //3.读取数据(一行一行读取数据)
            //①字符缓冲流里套字符流但是我们拿到是字节流。就将字节流转换成字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
            String line = "";
            while ((line = br.readLine()) != null) {
                //4.将数据切割
                String[] split = line.split("\t");// 数组中的内容为pid ,pname
                //5.将内容缓存到map中
                map.put(split[0], split[1]);
            }
        }finally {
            //4.关闭资源
            if (fs != null){
                fs.close();
            }
            if (fis != null){
                fis.close();
            }
        }
    }

    /*
        在任务结束的时候只执行一次。在map方法执行后执行
        作用 ：关闭资源
     */
    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {

    }

    /*
       读取Order.txt中的内容并进行Join的操作
    */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.切割数据 : 1001	01	1
        String[] split = value.toString().split("\t");
        //2.字符串拼接 ： id  pname  amount
        String info = split[0] + " " + map.get(split[1])  + " " + split[2];
        //3.封装key,value
        //给key赋值
        outKey.set(info);
        //4.将key,value写出去
        context.write(outKey,NullWritable.get());
    }
}
