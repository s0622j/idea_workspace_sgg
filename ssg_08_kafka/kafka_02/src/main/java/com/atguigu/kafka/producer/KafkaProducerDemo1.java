package com.atguigu.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * 生产者 - 异步发送 - 带回调
 *
 * 配置类
 *   CommonClientConfigs : 通用的配置类
 *   ProducerConfig ： 生产者的配置类
 *   ConsumerConfig :  消费者的配置类
 *
 */
public class KafkaProducerDemo1 {
    public static void main(String[] args) {
        //0. 创建配置对象
        Properties props= new Properties();

        //kafka集群，broker-list
        props.put("bootstrap.servers", "hadoop102:9092");


        // ack的级别
        props.put("acks", "all");


        //重试次数
        props.put("retries", 3);

        //批次大小
        props.put("batch.size", 16384);

        //等待时间
        props.put("linger.ms", 1);

        //RecordAccumulator缓冲区大小
        props.put("buffer.memory", 33554432);  //32M

        // kv的序列化器
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        //1. 创建生产者对象
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);

        //2. 生产数据
        for (int i = 0; i < 10; i++) {
            kafkaProducer.send(
                    new ProducerRecord<String, String>("first", "atguigu####" + i)
                    , new Callback() {
                        /**
                         * 当消息发送完成后， 会调用该方法
                         * @param metadata  消息的元数据信息.
                         *
                         * @param exception 当消息发送过程中,如果抛出异常，会传入到该方法.
                         */
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception exception) {
                            if(exception != null){
                                System.out.println("消息发送失败: " + exception.getMessage());
                            }else{
                                System.out.println("消息发送成功: " + metadata.topic() +
                                        " : " + metadata.partition() +
                                        " : " + metadata.offset()
                                       );
                            }
                        }
                    });
        }

        //3. 关闭对象
        kafkaProducer.close();
    }
}
