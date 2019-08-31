package com.windy.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: windy
 * @create: 2019-08-03 10:03
 * 队列配置-发送发消息确认
 */
@Configuration
public class TransMqConfig {
    //简单队列配置开始
    private final static String pConfirm = "pConfirm";

    @Bean(name = "pConfirm")
    public Queue pConfirm() {
        return new Queue(pConfirm);
    }

}
