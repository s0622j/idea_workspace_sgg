package com.atguigu.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

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
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");  // "latest", "earliest", "none"  需要更换消费者组才生效，或者重置offset
        // 2. 创建kafka消费者对象
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        // 3. 消费者订阅Topic
        ArrayList<String> topics = new ArrayList<>();
        topics.add("atguigu");
        consumer.subscribe(topics);

//        // 手动将所有分区的 offset 重置到 earliest
//        //调用 subscribe() 后，消费者只是“订阅”了某些主题，但还没有实际分配到分区。
//        //只有在调用 poll() 之后，消费者才会加入消费者组，并通过再平衡（rebalance） 获得分区分配。
//        //因此，在调用 poll() 之前，consumer.assignment() 通常返回 null 或空集合，所以需要先调用 poll()。
//        consumer.poll(Duration.ofSeconds(1L));
//        // 手动将所有分区的 offset 重置到 earliest
//        Set<TopicPartition> assignment = consumer.assignment();
//        System.out.println("================assignment:"+assignment);
//        for (TopicPartition tp : assignment) {
//            System.out.println("===================================tp:" );
//            consumer.seek(tp, 0); // 0 表示 earliest
//            System.out.println("===================================tp:"+tp);
//        }

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

/**
 *
 * # 1. 停止消费者
 *
 * # 2. 重置消费者组的 offset
 * 方法一：
 * bin/kafka-consumer-groups.sh \
 *   --bootstrap-server hadoop102:9092 \
 *   --group group04 \
 *   --topic atguigu \
 *   --reset-offsets \
 *   --to-earliest \
 *   --execute
 *
 *   方法二：
 *   // 手动将所有分区的 offset 重置到 earliest
 *   consumer.poll(Duration.ofSeconds(1L));
 *   Set<TopicPartition> assignment = consumer.assignment();
 *   System.out.println("================assignment:"+assignment);
 *   for (TopicPartition tp : assignment) {
 *       System.out.println("===================================tp:" );
 *       consumer.seek(tp, 0); // 0 表示 earliest
 *       System.out.println("===================================tp:"+tp);
 *   }
 *
 */
