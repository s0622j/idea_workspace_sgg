package com.atguigu.mr.combiner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/*
    Mapper阶段会运行MapTask，MapTask会调用Mapper类
    作用 ：在该类中实现需要在MapTask中实现的业务逻辑代码

    Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT> :
         第一组泛型：
            KEYIN ：读取数据时的偏移量的类型
            VALUEIN ：读取的一行一行的数据的类型
         第二组泛型：
            KEYOUT : 写出的key的类型（在这是单词的类型）
            VALUEOUT : 写出的value的类型（在这是单词的数量的类型）
 */
public class WCMapper extends Mapper<LongWritable, Text,Text,LongWritable> {
    //3.1创建key的对象
    private Text outKey = new Text();
    //3.2创建value的对象
    private LongWritable outValue = new LongWritable();
    /**
     * 1.在map方法中实现需要在MapTask中实现的业务逻辑代码
     * 2.该方法在被循环调用，每调用一次传入一行数据
     * @param key 读取数据时的偏移量
     * @param value 读取的数据（一行一行的数据）
     * @param context 上下文（在这用来将key,value写出去）
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //super.map(key, value, context);
        //1.将数据进行切割
        //1.1将Text转成String---为了使用String API进行处理
        String line = value.toString();
        //1.2对数据切割
        String[] words = line.split(" ");

        //2.遍历数据
        for (String word : words) {
            //3.封装key,value
            //给key赋值
            outKey.set(word);
            //给value赋值
            outValue.set(1);
            //4.将key,value写出去
            context.write(outKey,outValue);
        }
    }
}
