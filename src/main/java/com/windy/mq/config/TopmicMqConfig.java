package com.windy.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * @author: windy
 * @create: 2019-08-18 11:20
 * mq topic模式
 */
public class TopmicMqConfig {
    @Bean(name = "message111")
    public Queue queueMessage() {
        return new Queue("topic.message111");
    }

    @Bean(name = "messages111")
    public Queue queueMessages() {
        return new Queue("topic.messages111");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange111");
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("message111") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message111");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages111") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
    }
}
