package com.atguigu.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author leon
 * @ClassName CustomProducerSync.java
 * @createTime 2022年05月18日 09:15:00
 */
public class CustomProducerSync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 创建配置对象
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop102:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        // 2. 创建kafkaproducer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // 3. 循环发送数据
        for(int i=1;i<11;i++){
            // 4. 造数据
            String message = "客观你好，我是"+i+"号，很高兴为您服务！";
            // 5. 创建ProducerRecord
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
                    "first",
                    message
            );

            System.out.println("你看看我在哪里？");

            // 6. 发送数据
            producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    // 7. 判断是否有异常
                    if(exception == null){
                        int partition = metadata.partition();
                        long offset = metadata.offset();
                        System.out.println("数据："+producerRecord.value()+"分区："+partition+", 偏移量："+offset);
                    }
                }
            }).get();
        }

        // 8. 关闭资源
        producer.close();
    }
}
