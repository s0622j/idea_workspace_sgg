package com.atguigu.mr.outputformat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.FileOutputStream;
import java.io.IOException;

/*
    自定义RecordWriter类
 */
public class MyRecordWriter extends RecordWriter<Text, NullWritable> {
    private FSDataOutputStream atguigu;
    private FSDataOutputStream other;
    /*
        创建流
     */
    public MyRecordWriter(TaskAttemptContext job) {
        try {
            //1.创建客户端对象（文件系统对象---操作HDFS）
            FileSystem fs = FileSystem.get(job.getConfiguration());
            //2.创建流
            //2.1获取输出路径
            Path outputPath = FileOutputFormat.getOutputPath(job);
            //2.2创建流
            atguigu = fs.create(new Path(outputPath, "atguigu.txt"));
            other = fs.create(new Path(outputPath, "other.txt"));
        }catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            //将编译时异常转为运行时异常
            throw new RuntimeException(e.getMessage());
        }

    }
    /**
     * 用来写数据。该方法在被循环调用每调用一次传入一个键值对
     * @param key reducer写出的key
     * @param value reducer写出的value
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public void write(Text key, NullWritable value) throws IOException, InterruptedException {
        String address = key.toString() + "\n";
        //判断是否包含atguigu
        if (address.contains("atguigu")){
            //写到atguigu.txt
            atguigu.write(address.getBytes());
        }else{//不包含atguigu
            //写到other.txt
            other.write(address.getBytes());
        }
    }

    /*
        关闭资源 :该方法会在写数据的操作结束会被调用
     */
    @Override
    public void close(TaskAttemptContext context) throws IOException, InterruptedException {
        //3.关闭资源
        if (other != null) {
            other.close();
        }
        if (atguigu != null) {
            atguigu.close();
        }
    }
}
