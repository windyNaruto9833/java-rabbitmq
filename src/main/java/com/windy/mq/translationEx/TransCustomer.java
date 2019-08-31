package com.windy.mq.translationEx;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;
import java.io.IOException;

/**
 * @author: windy
 * @create: 2019-08-03 10:02
 */
@Component
public class TransCustomer {

    private Logger logger= LoggerFactory.getLogger(TransCustomer.class);

    @RabbitListener(queues="pConfirm")
    public void processA(String msg,Channel channel,Message message) throws IOException {
        logger.info("ReceiveMessage:"+msg);
        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            logger.info("receiver success");
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            //ack返回false，并重新回到队列，api里面解释得很清楚
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            logger.info("receiver fail");
        }
    }
}
