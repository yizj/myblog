package com.zjl.myblog.service.impl;

import com.zjl.myblog.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/4
 * @date: 2019/12/4
 * @function: TODO
 */
@Service
public class MailServiceImpl implements MailService {

    @Resource
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送简单消息
     *
     * @throws
     */
    @Override
    public void sendSimpleEmail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage ( );
        simpleMailMessage.setFrom ( from );
        simpleMailMessage.setTo ( to );
        simpleMailMessage.setSubject ( subject );
        simpleMailMessage.setText ( content );
        javaMailSender.send ( simpleMailMessage );
    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage ( );
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper ( mimeMessage, true );
        mimeMessageHelper.setFrom ( from );
        mimeMessageHelper.setTo ( to );
        mimeMessageHelper.setSubject ( subject );
        mimeMessageHelper.setText ( content );
        File file = new File ( rscPath );
        FileSystemResource fileSystemResource = new FileSystemResource ( file );
        mimeMessageHelper.addInline ( rscId, fileSystemResource );
        javaMailSender.send ( mimeMessage );
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage ( );
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper ( mimeMessage, true );
        mimeMessageHelper.setFrom ( from );
        mimeMessageHelper.setTo ( to );
        mimeMessageHelper.setSubject ( subject );
        mimeMessageHelper.setText ( content );
        FileSystemResource fileSystemResource = new FileSystemResource ( new File ( filePath ) );
        String fileName = fileSystemResource.getFilename ( );
        mimeMessageHelper.addAttachment ( fileName, fileSystemResource );

        javaMailSender.send ( mimeMessage );
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage ( );
        // true表⽰示需要创建一个multipart message
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper ( message, true );
        mimeMessageHelper.setFrom ( from );
        mimeMessageHelper.setTo ( to );
        mimeMessageHelper.setSubject ( subject );
        mimeMessageHelper.setText ( content, true );
        javaMailSender.send ( message );
    }
}
