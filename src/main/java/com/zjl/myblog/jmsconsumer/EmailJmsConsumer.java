package com.zjl.myblog.jmsconsumer;

import com.zjl.myblog.jmsconsumer.dto.EmailJmsDto;
import com.zjl.myblog.service.MailService;
import com.zjl.myblog.utils.JsonClassConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/5
 * @date: 2019/12/5
 * @function: TODO
 */
@Service
public class EmailJmsConsumer {

    @Autowired
    private MailService mailService;

    @JmsListener ( destination = "EMAIL-ACTIVE",concurrency = "8")
    public void sendEmail(String jmsJson) throws MessagingException {
        EmailJmsDto emailJmsDto=JsonClassConvertUtil.stringToBean ( jmsJson,EmailJmsDto.class );
        mailService.sendHtmlMail ( emailJmsDto.getTo (),
                emailJmsDto.getSubject (),
                emailJmsDto.getContent ()
        );
    }
}
