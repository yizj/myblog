package com.zjl.myblog.jms;

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
    private final DestinationManager destinationManager;

    private final JmsMessagingTemplate jmsTemplate;

    @Autowired
    public JmsProducerImpl(DestinationManager destinationManager, JmsMessagingTemplate jmsTemplate) {
        super ( );
        this.destinationManager = destinationManager;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void send(String type, String step, String message) {
        Destination destination = destinationManager.getDestination ( type, step );
        jmsTemplate.convertAndSend ( destination, message );
    }
}
