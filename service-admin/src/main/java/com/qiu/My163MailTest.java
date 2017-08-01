package com.qiu;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;



public class My163MailTest {
	@Autowired  
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Test
    public void testSendSimple() {
        SimpleMailMessage message = new SimpleMailMessage();
 
        message.setFrom(username);
        message.setTo("qiu_yixing@163.com");
        message.setSubject("标题：测试标题");
        message.setText("测试内容部份");
        javaMailSender.send(message);
    }
}