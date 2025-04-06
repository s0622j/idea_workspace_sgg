package com.atguigu.mr.compare3;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/*
    在写数据的时候将key,value的顺序交换
 */
public class FlowReducer extends Reducer<FlowBean, Text,Text, FlowBean> {
    @Override
    protected void reduce(FlowBean flowBean, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //遍历values
        for (Text text : values) {
            //写出数据
            context.write(text,flowBean);
        }
    }
}
