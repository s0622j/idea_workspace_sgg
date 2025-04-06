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
    从本地向集群提交Job
    1.配置参数
         //设置在集群运行的相关参数-设置HDFS,NAMENODE的地址
        conf.set("fs.defaultFS", "hdfs://hadoop102:8020");
        //指定MR运行在Yarn上
        conf.set("mapreduce.framework.name","yarn");
        //指定MR可以在远程集群运行
        conf.set("mapreduce.app-submission.cross-platform", "true");
        //指定yarn resourcemanager的位置
        conf.set("yarn.resourcemanager.hostname", "hadoop103");
    2.打包
    3.
         将下面的代码注释掉
         job.setJarByClass(WCDriver3.class);
         添加如下代码
        job.setJar("jar包路径");
    4.
        VM Options : -DHADOOP_USER_NAME=atguigu
        program Arguments : hdfs://hadoop102:8020/input hdfs://hadoop102:8020/output2
 */
public class WCDriver3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        //设置在集群运行的相关参数-设置HDFS,NAMENODE的地址
        conf.set("fs.defaultFS", "hdfs://hadoop102:8020");
        //指定MR运行在Yarn上
        conf.set("mapreduce.framework.name","yarn");
        //指定MR可以在远程集群运行
        conf.set("mapreduce.app-submission.cross-platform", "true");
        //指定yarn resourcemanager的位置
        conf.set("yarn.resourcemanager.hostname", "hadoop103");


        Job job = Job.getInstance(conf);

        //job.setJarByClass(WCDriver3.class);
        job.setJar("C:\\work\\idea_workspace\\a_study\\idea_workspace_sgg\\ssg_05_hadoop\\target\\ssg_05_hadoop-1.0-SNAPSHOT.jar");

        job.setMapperClass(WCMapper.class);
        job.setReducerClass(WCReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        //将输入和输出路径通过main方法传参的方式传入
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));


        boolean b = job.waitForCompletion(true);
        System.out.println("b===" + b);
    }
}
