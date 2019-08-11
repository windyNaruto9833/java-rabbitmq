package com.windy.mq.sampleMq;

import domain.So;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author: windy
 * @create: 2019-08-03 10:02
 */
@Controller
@RequestMapping("simpleMq")
public class Producer {

    private Logger logger= LoggerFactory.getLogger(Producer.class);


    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/sendMessage")
    public void send() {
        String context = "hello " + new Date();
        logger.info("Sender : " + context);
        //发送字符串
        this.rabbitTemplate.convertAndSend("helloWorld", context);
        //发送json对象
        So so=new So();
        so.setOrderNum("1111");
        so.setCount(10);
        so.setStatus(1);
        logger.info("Sender----so : " + so);
        this.rabbitTemplate.convertAndSend("helloWorld", so);
    }
}
