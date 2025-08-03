package com.atguigu.kafka.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author leon
 * @ClassName CustomPartitoner.java
 * @createTime 2022年05月18日 10:11:00
 */
public class CustomPartitoner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        // 1. 获取解析可以
        String keyStr = key.toString();
        // 2. 计算key的哈希值
        int keyHashcode = keyStr.hashCode();
        // 3. 获取分区个数
        Integer number = cluster.partitionCountForTopic(topic);
        // 4. 计算分区
        int partition = Math.abs(keyHashcode) % number;
        return partition;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
