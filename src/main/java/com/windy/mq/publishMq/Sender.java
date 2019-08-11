package com.windy.mq.publishMq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@author: windy
 *@create: 2019-07-04 21:24
 */
@Controller
@RequestMapping("fanout")
public class Sender {

    private Logger logger= LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;


    @RequestMapping("/sendMessage")
    public void sendMessage() {
        logger.info("调用接口sendMessage");
        rabbitTemplate.convertAndSend("fanoutExchange", "", "11111");

    }
}
