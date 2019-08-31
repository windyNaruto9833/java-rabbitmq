package com.windy.mq.translationEx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author: windy
 * @create: 2019-08-25 15:15
 */
public class RabbitConfirmCallback implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {

    private Logger logger= LoggerFactory.getLogger(RabbitConfirmCallback.class);


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            logger.info("消息已确认 cause:{} - {}",correlationData);
        } else {
            logger.info("消息未确认 cause:{} - {}",correlationData);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        logger.info("消息被退回 {}" , message.toString());
    }
}
