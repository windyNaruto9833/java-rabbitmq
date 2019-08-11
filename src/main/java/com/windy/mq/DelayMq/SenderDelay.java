package com.windy.mq.DelayMq;
import com.windy.mq.config.DelayMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *@author: windy
 *@create: 2019-07-04 21:24
 */
@Controller
@RequestMapping("dealy")
public class SenderDelay {

    private Logger logger= LoggerFactory.getLogger(SenderDelay.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/sendMessage")
    public void sendMessage() {
        logger.info("调用接口/dealy/sendMessage");
        MessageProperties properties = new MessageProperties();
        properties.setDelay(20000);//延迟20秒
        Message message = new Message("delay_test_message".getBytes(), properties);
        rabbitTemplate.send(DelayMqConfig.EXCHANGE_NAME, DelayMqConfig.QUEUE_NAME, message);
    }
}
