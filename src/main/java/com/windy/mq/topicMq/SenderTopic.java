package com.windy.rabbitmq.topic;

import com.windy.rabbitmq.controller.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@author: windy
 *@create: 2019-07-04 21:24
 */
@Controller
@RequestMapping("topic")
public class SenderTopic {

    private Logger logger= LoggerFactory.getLogger(TestController.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;


    @RequestMapping("sendMessage")
    public void sendMessage() {
        logger.info("调用接口/topic/sendMessage");
        rabbitTemplate.convertAndSend("exchange111", "topic.message111", "hello, rabbit!");
//        rabbitTemplate.convertAndSend("exchange111", "topic.messages111", "hello, rabbit!");

    }

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        return "success";
    }

    @ResponseBody
    @RequestMapping("hello333")
    public String hello2222() {
        return "success";
    }





}
