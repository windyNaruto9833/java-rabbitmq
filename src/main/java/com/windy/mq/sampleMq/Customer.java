package com.windy.mq.sampleMq;

import domain.So;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: windy
 * @create: 2019-08-03 10:02
 */
@Component
public class Customer {

    private Logger logger= LoggerFactory.getLogger(Customer.class);

    @RabbitListener(queues="helloWorld")
    public void processA(String msg) {
        logger.info("ReceiveA:"+msg);
    }

    @RabbitListener(queues="helloWorld")
    public void processA(So so) {
        logger.info("processB:"+so);
    }
}
