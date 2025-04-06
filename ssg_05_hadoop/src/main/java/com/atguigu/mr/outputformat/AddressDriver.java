package com.atguigu.mr.outputformat;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class AddressDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //设置使用自定义的OutputFormat类如果不设置使用的是TextOutputFormat
        job.setOutputFormatClass(MyOutputFormat.class);
        job.setMapperClass(AddressMapper.class);
        job.setReducerClass(AddressReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        FileInputFormat.setInputPaths(job,new Path("D:\\io\\input7"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\io\\output7"));


        job.waitForCompletion(true);
    }
}
