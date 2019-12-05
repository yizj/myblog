package com.zjl.myblog.jmsproducer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/4
 * @date: 2019/12/4
 * @function: TODO
 */
@Service
public class AmqDestinationManager implements DestinationManager {

    private final String DESTINATION_NAME_TEMPLATE = "%s-%s";

    private final Map<String, Destination> destinationMap;

    public AmqDestinationManager() {
        super ( );
        this.destinationMap = new ConcurrentHashMap<> ( 16 );
    }

    @Override
    public Destination getDestination(String type, String step) {
        String destinationName = getDestinationName ( type, step );
        if (!destinationMap.containsKey ( destinationName )) {
            return generateDestination ( destinationName );
        }
        return destinationMap.get ( destinationName );
    }

    private String getDestinationName(String type, String step) {
        return String.format ( DESTINATION_NAME_TEMPLATE, type, step );
    }

    private synchronized Destination generateDestination(String destinationName) {

        if (!destinationMap.containsKey ( destinationName )) {
            Destination destination = new ActiveMQQueue ( destinationName );
            destinationMap.put ( destinationName, destination );
            return destination;
        } else {
            return destinationMap.get ( destinationName );
        }
    }
}
