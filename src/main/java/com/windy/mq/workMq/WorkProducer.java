package com.windy.mq.workMq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: windy
 * @create: 2019-08-03 10:02
 */
@Controller
@RequestMapping("workMq")
public class WorkProducer {

    private Logger logger= LoggerFactory.getLogger(WorkProducer.class);


    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/sendMessage")
    public void send() {
        for (int i=0;i<10;i++){
            this.rabbitTemplate.convertAndSend("workMq", i);
        }
    }
}
