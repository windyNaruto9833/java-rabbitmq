package com.windy.mq.translationEx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * @author: windy
 * @create: 2019-08-03 10:02
 */
@Controller
@RequestMapping("translationEx")
public class TransProducer {

    private Logger logger= LoggerFactory.getLogger(TransProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void initRabbitTemplate() {
        // 设置生产者消息确认
        rabbitTemplate.setConfirmCallback(new RabbitConfirmCallback());
        rabbitTemplate.setReturnCallback(new RabbitConfirmCallback());
    }

    @RequestMapping("/sendMessage")
    public void send() {
        //发送字符串
        for(int i=0;i<10;i++){
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            this.rabbitTemplate.convertAndSend(null,"pConfirm", "a"+i,correlationData);
        }
    }
}
