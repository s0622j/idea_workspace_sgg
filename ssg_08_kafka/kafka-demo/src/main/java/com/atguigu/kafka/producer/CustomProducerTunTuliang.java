package com.atguigu.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author leon
 * @ClassName CustomProducer.java
 * @createTime 2022年05月17日 15:38:00
 */
public class CustomProducerTunTuliang {
    public static void main(String[] args) {
        // 1. 创建配置对象
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop102:9092,hadoop103:9092");
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.atguigu.kafka.partitioner.CustomPartitoner");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 增加吞吐量
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);  //缓冲区大小，默认32M
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,16384);  // 批次大小，默认16K
        properties.put(ProducerConfig.LINGER_MS_CONFIG,10);  // 等待时间，默认0ms  10ms
        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG,"snappy");  // 压缩

        // 2. 创建kafka生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);


        // 3. 发送数据
        for(int i=1;i<11;i++){
            // 4. 造数据
            String message="你好客官，我是"+i+"号，很高兴为您服务";
            // 5. 创建produerRecord
            final ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
                "first",
                    i+"",
                    message
            );

            System.out.println("你看看我在哪里？");

            // 6. 发送数据
            producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    // 6.1 当发送成功时输出元数据信息
                    if(exception == null) {
                        long offset = metadata.offset();
                        int partition = metadata.partition();
                        System.out.println(producerRecord.value()+", 分区："+partition+", 偏移量："+offset);
                    }

                }
            });
        }

        // 7.关闭资源
        producer.close();

    }
}
