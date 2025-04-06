package com.atguigu.mr.wordcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

/*
    Reduce阶段会运行ReduceTask，ReduceTask会调用Reducer类
    作用 ：在该类中实现需要在ReduceTask中实现的业务逻辑代码

    Reducer<KEYIN, VALUEIN, KEYOUT, VALUEOUT>:
        第一组泛型：
            KEYIN ：读取的key的类型（Mapper写出的key的类型）
            VALUEIN ：读取的value的类型（Mapper写出的value的类型）
        第二组泛型：
            KEYOUT ：写出的key的类型（在这是单词的类型）
            VALUEOUT ：写出的value的类型（在这是单词的数量）
 */
public class WCReducer extends Reducer<Text, LongWritable,Text,LongWritable> {
    private LongWritable outValue = new LongWritable();//创建的value的对象
    /**
     * 1.在reduce方法中实现需要在ReduceTask中实现在的业务逻辑代码
     * 2.reduce方法在被循环调用，每调一次传入一组数据（在这key值相同为一组）
     * @param key 读取的key
     * @param values 读取的所有的value
     * @param context 上下文（在这用来将key,value写出去）
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long sum = 0;//value的和
        //super.reduce(key, values, context);
        //1.遍历所有的value
        //Iterator<LongWritable> iterator = values.iterator();通过iterator进行遍历
        for (LongWritable value : values) {
            //2.对value进行累加
            //将LongWritable转成long
            long v = value.get();
            //累加value
            sum += v;
        }
        //3.封装key,value
        //给value赋值
        outValue.set(sum);
        //4.将key,value写出去
        context.write(key,outValue);
    }
}
