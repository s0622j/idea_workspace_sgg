package com.atguigu.mr.partition3;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner<Text, LongWritable> {
    @Override
    public int getPartition(Text text, LongWritable longWritable, int numPartitions) {
        String word = text.toString();
        char c = word.charAt(0);
        if ((c >= 'a' && c <= 'p') || (c >= 'A' && c <= 'P')){
            return 0;
        }else{
            return 1;
        }
    }
}
