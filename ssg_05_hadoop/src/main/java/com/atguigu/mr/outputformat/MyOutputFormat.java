package com.atguigu.mr.outputformat;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/*
    自定义OutputFormat类：
        1.自定义一个类并继承FileOutputFormat。因为继承该类只需要重写getRecordWriter方法。
                而getRecordWriter是用来获取RecordWriter对象。RecordWriter对象是用来真正写数据的。

    FileOutputFormat<K, V> :
            K : Reducer写出的key的类型
            V : Reducer写出的value的类型
 */
public class MyOutputFormat extends FileOutputFormat<Text, NullWritable> {
    /*
        在方法中创建RecordWriter的对象并返回
     */
    @Override
    public RecordWriter<Text, NullWritable> getRecordWriter(TaskAttemptContext job) throws IOException, InterruptedException {
        return new MyRecordWriter(job);
    }
}
