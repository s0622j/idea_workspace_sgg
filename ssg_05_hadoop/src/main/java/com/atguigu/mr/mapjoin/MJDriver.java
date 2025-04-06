package com.atguigu.mr.mapjoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MJDriver {
    public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException, InterruptedException {
        Job job = Job.getInstance(new Configuration());

        //添加缓存文件的路径
        job.addCacheFile(new URI("file:///D:/io/input9/pd.txt"));

        //如果没有Reducer可以将ReduceTask的数量设置成0
        job.setNumReduceTasks(0);//如果设置为0将不再对key进行排序

        job.setMapperClass(MJMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        FileInputFormat.setInputPaths(job,new Path("D:\\io\\input9\\order.txt"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\io\\output99"));

        job.waitForCompletion(true);
    }
}
