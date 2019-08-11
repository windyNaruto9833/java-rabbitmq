package com.windy.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: windy
 * @create: 2019-08-03 10:03
 * 简单队列配置
 */
@Configuration
public class SimpleMqConfig {
    //简单队列配置开始
    private final static String workQunne = "helloWorld";

    @Bean
    public Queue helloWorld() {
        return new Queue(workQunne);
    }
}
