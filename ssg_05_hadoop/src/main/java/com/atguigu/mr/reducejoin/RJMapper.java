package com.atguigu.mr.reducejoin;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class RJMapper extends Mapper<LongWritable, Text,OrderBean, NullWritable> {
    //创建key的对象
    private OrderBean outKey = new OrderBean();
    //文件名
    private String fileName;

    /*
        在任务开始的时候只执行一次。在map方法执行前执行
     */
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        FileSplit inputSplit = (FileSplit) context.getInputSplit();//获取切片信息
        fileName = inputSplit.getPath().getName();//获取切片所属文件的名字
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.切割数据
        String[] split = value.toString().split("\t");
        //2.封装key,value
        if ("order.txt".equals(fileName)){
            //1001	01	1
            outKey.setId(Integer.parseInt(split[0]));
            outKey.setPid(Integer.parseInt(split[1]));
            outKey.setAmount(Integer.parseInt(split[2]));
            //一定要设置:因为会用该字段进行排序，如果不设置会发生空指针异常
            outKey.setPname("");
        }else if("pd.txt".equals(fileName)){
            //01 小米
            outKey.setPid(Integer.parseInt(split[0]));
            outKey.setPname(split[1]);
        }
        //3.将key,vlaue写出去
        context.write(outKey,NullWritable.get());
    }
}
