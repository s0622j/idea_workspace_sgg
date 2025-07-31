package com.atguigu.kafka.flumeinterceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class DataValueInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {
        //1. 获取headers
        Map<String, String> headers = event.getHeaders();
        //2. 获取body
        String body = new String(event.getBody(), StandardCharsets.UTF_8);
        //3. 判断处理
        if(body.contains("atguigu")){
            headers.put("topic","topicat");
        }else if(body.contains("shangguigu")){
            headers.put("topic","topicst");
        }
        return event;
    }

    @Override
    public List<Event> intercept(List<Event> events) {
        for (Event event : events) {
            intercept(event);
        }
        return events;
    }

    @Override
    public void close() {

    }

    public static class MyBuilder implements Builder{

        @Override
        public Interceptor build() {
            return new DataValueInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
