package com.zjl.myblog.jms;

public interface JmsProducer {

    void send(String type,String step,String message);
}
