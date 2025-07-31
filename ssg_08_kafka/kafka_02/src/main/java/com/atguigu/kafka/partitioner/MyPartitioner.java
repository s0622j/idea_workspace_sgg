package com.atguigu.kafka.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * 自定义分区器 需要实现Kafka提供的partitioner接口
 */
public class MyPartitioner implements Partitioner {
    /**
     * 计算分区号
     * 以first主题为例， 有两个分区.
     * 包含atguigu的消息发送0号分区
     * 其他消息发送1号分区
     *
     *
     * @param topic  当前消息发往的主题
     * @param key    当前消息的key
     * @param keyBytes  当前消息的key序列化后字节数组
     * @param value  当前消息的值
     * @param valueBytes 当前消息的值序列化后的字节数组
     * @param cluster
     * @return
     */
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        if(value.toString().contains("atguigu")){
            return 0 ;
        }else{
            return 1 ;
        }

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
