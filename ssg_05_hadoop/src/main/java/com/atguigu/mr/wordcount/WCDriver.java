package com.atguigu.mr.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/*
    程序的入口
    1.创建Job实例并运行

    遇到的问题：
        1.导包错误 ：ClassCastException
        2.  重复设置
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputKeyClass(LongWritable.class);

        3.调用父类的方法
            super.map(key, value, context);

        4.NativeIOxxxxxxxx
            ①代码写错了 ---- 先用龙哥的代码试错、
            ②创建org.apache.hadoop.io.nativeio
                        将NativeIo.java粘贴到此包中
            ③windows登录的用户是中文或者有空格导致的
                    windows需要创建新的用户
 */
public class WCDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1.创建Job实例
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //2.给Job赋值
        //2.1关联本程序的Jar--如果是本地可以不写在集群上运行必须写
        job.setJarByClass(WCDriver.class);
        //2.2设置Mapper和Reducer类
        job.setMapperClass(WCMapper.class);
        job.setReducerClass(WCReducer.class);
        //2.3设置Mapper输出的key,value的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        //2.4设置最终输出的key,value的类型（在这是reducer输出的key,value的类型）
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        //2.5设置输入和输出路径
        FileInputFormat.setInputPaths(job,new Path("D:\\test\\input"));
        //输出路径一定不能存在否则报错
        FileOutputFormat.setOutputPath(job,new Path("D:\\test\\output222"));

        //3.运行Job
        /*
             boolean waitForCompletion(boolean verbose)
             verbose : 是否打印信息
             返回值 ：如果job执行成功返回true
         */
        boolean b = job.waitForCompletion(true);
        System.out.println("b===" + b);
    }
}
