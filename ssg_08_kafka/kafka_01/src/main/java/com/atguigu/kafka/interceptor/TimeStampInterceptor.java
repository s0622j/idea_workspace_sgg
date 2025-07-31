package com.atguigu.kafka.interceptor;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * 该拦截器实现的功能:
 *    将时间戳添加到消息的前面.
 */
public class TimeStampInterceptor implements ProducerInterceptor<String,String> {

    /**
     * 拦截器的核心处理方法
     * @param record  被拦截处理的消息
     * @return
     */
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        // 1. 获取消息的value
        String value = record.value();
        String result = System.currentTimeMillis() + "->" + value ;

        //2. 重新构建新的消息对象
        ProducerRecord<String, String> newRecord =
                new ProducerRecord<>(record.topic(), record.partition(), record.key(), result);

        return newRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
