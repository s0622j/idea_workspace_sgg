package com.atguigu.flume.interceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.Collections;
import java.util.List;

public class CustomInterceptor implements Interceptor {
    /**
     * 初始化方法
     */
    @Override
    public void initialize() {
    }

    /**
     * 拦截单个事件的方法
     * @param event
     * @return
     */
    @Override
    public Event intercept(Event event) {
        // 1. 从事件中获取数据
        byte[] body = event.getBody();
        // 2. 判断数据开头的字符是字母还是数据
        if (body[0] >= 'a' && body[0] <= 'z') {
            event.getHeaders().put("type", "letter");         // 是字母就在事件头部设置type类型为letter
        } else if (body[0] >= '0' && body[0] <= '9') {
            event.getHeaders().put("type", "number");         // 是数字就在事件头部设置type类型为number
        }
        // 3. 返回事件
        return event;

    }
    // 对批量事件进行拦截
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
    // 拦截器对象的构造对象
    public static class Builder implements Interceptor.Builder {

        @Override
        public Interceptor build() {
            return new CustomInterceptor();
        }

        @Override
        public void configure(Context context) {
        }
    }
}
