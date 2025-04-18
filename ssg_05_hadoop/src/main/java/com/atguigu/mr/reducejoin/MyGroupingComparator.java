package com.atguigu.mr.reducejoin;


import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
/*
    自定义分组类：如果不自定义那么默认分组方式和排序方式相同
    1.自定义一个类并继承WritableComparator
    2.调用父类指定的构造器
    3.重写父类的方法(注意参数类型)compare(WritableComparable a, WritableComparable b)
 */

public class MyGroupingComparator extends WritableComparator {
    public MyGroupingComparator(){
        /*
        调用父类的构造器
        WritableComparator(Class<? extends WritableComparable> keyClass,boolean createInstances)
        keyClass : key的运行时类
        createInstances ：是否创建实例（必须为true）
        */
        super(OrderBean.class,true);
    }

    //重写父类的方法
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        //向下转型
        OrderBean o1 = (OrderBean) a;
        OrderBean o2 = (OrderBean) b;
        return o1.getPid()-o2.getPid();//按照pid分组
    }
}
