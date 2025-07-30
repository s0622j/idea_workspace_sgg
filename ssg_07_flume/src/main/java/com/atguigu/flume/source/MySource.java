package com.atguigu.flume.source;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.PollableSource;
import org.apache.flume.conf.Configurable;
import org.apache.flume.event.SimpleEvent;
import org.apache.flume.source.AbstractSource;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 自定义Source 需要继承AbstractSource,实现 Configurable ,PollableSource接口.
 */
public class MySource extends AbstractSource implements Configurable, PollableSource {
    private String prefix;

    /**
     * Source的核心处理方法,
     *
     * 该方法在flume的处理流程中是循环调用的。
     * @return
     * @throws EventDeliveryException
     */
    @Override
    public Status process() throws EventDeliveryException {
        //休眠一秒中
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Status status = null ;
        try {

            // Receive new data
            // 采集数据，封装成event对象
            Event e = getSomeData();

            // Store the Event into this Source's associated Channel(s)
            // 将event对象交给ChannelProcessor进行处理
            getChannelProcessor().processEvent(e);
            // 正常处理,返回Status.READY
            status = Status.READY;
        } catch (Throwable t) {
            // Log exception, handle individual exceptions as needed
            // 处理失败,返回 Status.BACKOFF
            status = Status.BACKOFF;
        }
        return status;
    }

    /**
     * 随机生成一个字符串作为采集的数据
     * @return
     */
    private Event getSomeData() {
        String data  = UUID.randomUUID().toString();
        String resultData = prefix + data ;
        SimpleEvent event = new SimpleEvent();
        event.setBody(resultData.getBytes(StandardCharsets.UTF_8));
        event.getHeaders().put("author","wyh");
        return event ;
    }

    /**
     * 规避时间的增长步长
     * @return
     */
    @Override
    public long getBackOffSleepIncrement() {
        return 1;
    }

    /**
     * 最大的规避时间
     * @return
     */
    @Override
    public long getMaxBackOffSleepInterval() {
        return 10;
    }

    /**
     * 用于读取flume的配置信息 xxx.conf
     * @param context
     */
    @Override
    public void configure(Context context) {
        prefix = context.getString("prefix","log-");
    }
}
