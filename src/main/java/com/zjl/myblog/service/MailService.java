package com.zjl.myblog.service;

import javax.mail.MessagingException;

public interface MailService {
    /**
      * 简单类型的邮件
      * @exception
      */
    void sendSimpleEmail(String to,String subject,String content);
    /**
     * 富文本邮件
     * @exception
     */
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException;
    /**
     * 带附件邮件
     * @exception
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException;
    /**
     * Html邮件
     * @exception
     */
    void sendHtmlMail(String to, String subject, String content) throws MessagingException;
}
