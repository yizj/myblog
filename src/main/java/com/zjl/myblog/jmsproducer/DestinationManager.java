package com.zjl.myblog.jmsproducer;

import javax.jms.Destination;
/**
 * @Author:jlzhang
 * @Description: 目的地管理器
 * @Date:Created in 2019/10/31
 */
public interface DestinationManager {
    /**
      *
      * 得到队列目的地
      *
      * @exception
      */
    Destination getDestination(String type,String step);
}
