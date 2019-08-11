package com.windy.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: windy
 * @create: 2019-08-03 10:03
 * 工作队列配置
 */
@Configuration
public class WorkMqConfig {
    private final static String workQunne = "workMq";

    @Bean
    public Queue workMq() {
        return new Queue(workQunne);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                                               ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setPrefetchCount(1);
        configurer.configure(factory, connectionFactory);
//        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);             //开启手动 ack
        return factory;
    }

}
