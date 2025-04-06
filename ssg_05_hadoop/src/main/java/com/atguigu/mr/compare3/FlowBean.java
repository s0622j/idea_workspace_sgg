package com.atguigu.mr.compare3;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/*
    将自定义的类在MR中作为key,那么必须能够序列化和排序
    1.自定义一个类并实现WritableComparable接口
    2.WritableComparable继承了 Writable和Comparable接口
    3.重写接口中的方法
 */
public class FlowBean implements WritableComparable<FlowBean> {
    private long upFlow;
    private long downFlow;
    private long sumFlow;

    public FlowBean(){

    }
    /*
        排序 ：按照指定的属性进行排序
     */
    @Override
    public int compareTo(FlowBean o) {
        //按照总流量进行排序
        return -Long.compare(this.sumFlow,o.sumFlow);
    }

    /*
        序列化时调用此方法
     */
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(upFlow);
        out.writeLong(downFlow);
        out.writeLong(sumFlow);
    }

    /*
        反序列化时调用此方法（序列化和反序列化时的顺序必须保持一致）
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        upFlow = in.readLong();
        downFlow = in.readLong();
        sumFlow = in.readLong();
    }

    @Override
    public String toString() {
        return upFlow + " " + downFlow + " " + sumFlow;
    }

    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(long downFlow) {
        this.downFlow = downFlow;
    }

    public long getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(long sumFlow) {
        this.sumFlow = sumFlow;
    }
}
