package com.atguigu.flume.interceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * 自定义拦截器 需要实现Flume提供的Interceptor接口.
 */
public class EventHeaderInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }
    /**
     * 拦截方法
     * @param event
     * @return
     */
    @Override
    public Event intercept(Event event) {
        //1. 获取event的headers
        Map<String, String> headers = event.getHeaders();
        //2. 获取event的body
        String body = new String(event.getBody(), StandardCharsets.UTF_8);
        //3. 判断body中是否包含  "atguigu"  "shangguigu"
        if(body.contains("atguigu")){
            headers.put("title","at");
        }else if (body.contains("shangguigu")){
            headers.put("title","st");
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

    public static class MyBuilder implements  Builder{

        @Override
        public Interceptor build() {
            return new EventHeaderInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
