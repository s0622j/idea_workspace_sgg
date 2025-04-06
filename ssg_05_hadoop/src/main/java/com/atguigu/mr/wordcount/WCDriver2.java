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
    在集群上跑Job
    1.将输入和输出路径通过main方法传参的方式传入
    2.打包
    3.将jar包上传到集群上
    4.执行命令: hadoop jar xxx.jar 全类名  输入路径  输出路径
        案例 :hadoop jar MRDemo-1.0-SNAPSHOT.jar com.atguigu.mr.wordcount.WCDriver2 /input /output
        案例 :hadoop jar ssg_05_hadoop-1.0-SNAPSHOT.jar com.atguigu.mr.wordcount.WCDriver2 /input2 /output2
 */
public class WCDriver2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(WCDriver2.class);
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
