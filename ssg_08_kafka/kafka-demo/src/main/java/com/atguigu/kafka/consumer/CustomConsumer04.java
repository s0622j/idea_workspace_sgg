package com.atguigu.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author leon
 * @ClassName CustomConsumer01.java
 * @createTime 2022年05月20日 10:25:00
 */
public class CustomConsumer04 {
    public static void main(String[] args) {
        // 1. 创建配置对象
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop102:9092");

        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"group04");

        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"false");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,5000);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        // 2. 创建kafka消费者对象
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        // 3. 消费者订阅Topic
        ArrayList<String> topics = new ArrayList<>();
        topics.add("atguigu");
        consumer.subscribe(topics);

        // 4. 不断的轮询拉取数据
        while (true){
            // 5. 拉取数据
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1L));

            // 6. 解析数据
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                String value = consumerRecord.value();
                int partition = consumerRecord.partition();
                long offset = consumerRecord.offset();
                System.out.println("数据："+value+", 分区："+partition+", 偏移量："+offset);
            }

            // 7. 提交offset
            //consumer.commitSync();
            consumer.commitAsync();

        }

    }
}
