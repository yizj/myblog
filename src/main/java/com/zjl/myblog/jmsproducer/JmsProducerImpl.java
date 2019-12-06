package com.zjl.myblog.jmsproducer;

import com.zjl.myblog.annotation.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/4
 * @date: 2019/12/4
 * @function: TODO
 */
@Service
public class JmsProducerImpl implements JmsProducer {

    @Autowired
    private  DestinationManager destinationManager;

    @Autowired
    private  JmsMessagingTemplate jmsTemplate;

    @Override
    @Log("消息发送")
    public void send(String type, String step, String message) {
        Destination destination = destinationManager.getDestination ( type, step );
        jmsTemplate.convertAndSend ( destination, message );
    }
}
