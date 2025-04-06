package com.atguigu.mr.reducejoin;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/*
    OrderBean作为key
 */
public class OrderBean implements WritableComparable<OrderBean> {
    private int id;
    private int pid;
    private int amount;
    private String pname;

    public OrderBean(){

    }

    public OrderBean(int id, int pid, int amount, String pname) {
        this.id = id;
        this.pid = pid;
        this.amount = amount;
        this.pname = pname;
    }

    @Override
    public int compareTo(OrderBean o) {
        //先按照Pid进行排序，如果Pid相同再按照pname排序
        int cpid = this.pid - o.getPid();
        if (cpid == 0){
            return -this.pname.compareTo(o.getPname());
        }
        return cpid;
    }

    /*
        序列化时调用的方式
     */
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(id);
        out.writeInt(pid);
        out.writeInt(amount);
        out.writeUTF(pname);
    }

    /*
        反序列化调用的方法 ：要和序列化顺序保持一致
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        id = in.readInt();
        pid = in.readInt();
        amount = in.readInt();
        pname = in.readUTF();
    }

    @Override
    public String toString() {
        return id + " " + pid + " " + pname + " " + amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }


}
