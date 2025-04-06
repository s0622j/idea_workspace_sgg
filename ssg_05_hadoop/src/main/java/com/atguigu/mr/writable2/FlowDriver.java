package com.atguigu.mr.writable2;

import com.atguigu.mr.wordcount.WCDriver;
import com.atguigu.mr.wordcount.WCMapper;
import com.atguigu.mr.wordcount.WCReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1.创建Job实例
        Job job = Job.getInstance(new Configuration());

        //2.给Job赋值
        //2.1关联本程序的Jar--如果是本地可以不写在集群上运行必须写
        job.setJarByClass(FlowDriver.class);
        //2.2设置Mapper和Reducer类
        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);
        //2.3设置Mapper输出的key,value的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);
        //2.4设置最终输出的key,value的类型（在这是reducer输出的key,value的类型）
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);
        //2.5设置输入和输出路径
        FileInputFormat.setInputPaths(job,new Path("D:\\io\\input2"));
        //输出路径一定不能存在否则报错
        FileOutputFormat.setOutputPath(job,new Path("D:\\io\\output2"));

        //3.运行Job
        /*
             boolean waitForCompletion(boolean verbose)
             verbose : 是否打印信息
             返回值 ：如果job执行成功返回true
         */
        job.waitForCompletion(true);
    }
}
