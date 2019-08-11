package com.windy.mq.workMq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: windy
 * @create: 2019-08-03 10:02
 */
@Component
public class WorkCustomer {

    private Logger logger= LoggerFactory.getLogger(WorkCustomer.class);

    @RabbitListener(queues="workMq")
    public void processA(int msg) {
        logger.info("ReceiveA:"+msg);
    }

}
