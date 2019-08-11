package com.windy.mq.DelayMq;
import com.windy.mq.config.DelayMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: windy
 * @create: 2019-07-07 10:22
 */
@Component
public class ReceiverDelay {
    private Logger logger= LoggerFactory.getLogger(ReceiverDelay.class);

    @RabbitListener(queues = DelayMqConfig.QUEUE_NAME)
    public void consumer(Message message) {
        logger.info(new Date() + " ---> " + new String(message.getBody()));
    }
}
