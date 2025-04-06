package com.atguigu.mr.writable2;

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
            KEYOUT : 写出的key的类型（在这是手机号的类型）
            VALUEOUT : 写出的value的类型（在这是FlowBean）
 */
public class FlowMapper extends Mapper<LongWritable, Text,Text,FlowBean> {
    private Text outKey = new Text();//创建的key的对象
    private FlowBean outValue = new FlowBean();//创建的value的对象
    /**
     * 1.在map方法中实现需要在MapTask中实现的业务逻辑代码
     * 2.该方法在被循环调用，每调用一次传入一行数据
     * @param key 读取数据时的偏移量
     * @param value 读取的数据（一行一行的数据）
     * @param context 上下文（在这用来将key,value写出去）
     * @throws IOException
     * @throws InterruptedException
     *
     * 1	13736230513	192.196.100.1	www.atguigu.com	2481	24681	200
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.将数据切割
        String[] phoneInfo = value.toString().split("\t");
        //2.封装key,value
        //给key赋值
        outKey.set(phoneInfo[1]);
        //给value赋值
        outValue.setUpFlow(Long.parseLong(phoneInfo[phoneInfo.length-3]));
        outValue.setDownFlow(Long.parseLong(phoneInfo[phoneInfo.length-2]));
        outValue.setSumFlow(outValue.getUpFlow()+outValue.getDownFlow());
        //3.将key,value写出去
        context.write(outKey,outValue);
    }
}
