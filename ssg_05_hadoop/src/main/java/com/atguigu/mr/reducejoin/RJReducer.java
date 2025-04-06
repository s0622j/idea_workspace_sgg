package com.atguigu.mr.reducejoin;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class RJReducer extends Reducer<OrderBean, NullWritable,OrderBean,NullWritable> {

    /*
                        key                         value
         0        1       0       小米                null
         1001     1       1 　     ""                 null
         1004     1       4        ""                 null

        1.获取第一组数据的key的pname值
        2.遍历后面所有的数据(key,value)
        3.将第一组数据的key的pname替换后面所有的key的pname
        4.将key,value写出去

        注意 ：当我们遍历value的时候那么key就会指向value对应的key

     */
    @Override
    protected void reduce(OrderBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        //1.获取第一组数据的key的pname值
        //获取迭代器
        Iterator<NullWritable> iterator = values.iterator();
        //指针下移（获取第一条数据的value同时key指向第一条key）
        NullWritable next = iterator.next();
        //获取第一条数据的pname
        String pname = key.getPname();


        //2.遍历后面所有的数据(key,value)
        while(iterator.hasNext()){
            iterator.next();//指针下移
            //3.将第一组数据的key的pname替换后面所有的key的pname
            key.setPname(pname);
            //4.将key,value写出去
            context.write(key,NullWritable.get());
        }
    }
}
