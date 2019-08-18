package com.windy.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *@author: windy
 *@create: 2019-07-04 21:28
 */
@Component
public class ReceiverTopic {
    @RabbitListener(queues="topic.message111")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:"+str);
    }

    @RabbitListener(queues="topic.messages111")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("messages:"+str);
    }



}
