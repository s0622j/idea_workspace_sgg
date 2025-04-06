package com.atguigu.mr.writable2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/*
    Reduce阶段会运行ReduceTask，ReduceTask会调用Reducer类
    作用 ：在该类中实现需要在ReduceTask中实现的业务逻辑代码

    Reducer<KEYIN, VALUEIN, KEYOUT, VALUEOUT>:
        第一组泛型：
            KEYIN ：读取的key的类型（Mapper写出的key的类型）
            VALUEIN ：读取的value的类型（Mapper写出的value的类型）
        第二组泛型：
            KEYOUT ：写出的key的类型（在这是手机号的类型）
            VALUEOUT ：写出的value的类型（在这是FlowBean）
 */
public class FlowReducer extends Reducer<Text,FlowBean,Text,FlowBean> {
    private FlowBean outValue = new FlowBean();//创建value对象
    /**
     * 1.在reduce方法中实现需要在ReduceTask中实现在的业务逻辑代码
     * 2.reduce方法在被循环调用，每调一次传入一组数据（在这key值相同为一组）
     * @param key 读取的key
     * @param values 读取的所有的value
     * @param context 上下文（在这用来将key,value写出去）
     * @throws IOException
     * @throws InterruptedException
     *
     * 15322222222  10  10  20
     * 15322222222  5  6  11
     */
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        long sumUpFlow = 0;//总上行
        long sumDownFlow = 0;//总下行
        //1.遍历所有的value
        for (FlowBean value : values) {
            //将上行流量累加
            sumUpFlow += value.getUpFlow();
            //将下行流量累加
            sumDownFlow += value.getDownFlow();
        }
        //2.封装key,value
        //给value赋值
        outValue.setUpFlow(sumUpFlow);
        outValue.setDownFlow(sumDownFlow);
        outValue.setSumFlow(outValue.getUpFlow()+outValue.getDownFlow());
        //3.将key,value写出去
        context.write(key,outValue);

    }
}
