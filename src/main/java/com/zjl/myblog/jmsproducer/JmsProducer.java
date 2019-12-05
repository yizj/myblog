package com.zjl.myblog.jmsproducer;

public interface JmsProducer {

    void send(String type,String step,String message);
}
