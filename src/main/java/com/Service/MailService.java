package com.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender Sender;
    private TokenService tokenService = new TokenService();
    private static final Logger log = LoggerFactory.getLogger(MailService.class);
    private SimpleMailMessage message = new SimpleMailMessage();
    private String link = "http://192.168.102/";

    public void send_mail(String email){
        message.setFrom("dk6coqznk7gy3ymx@ethereal.email");
        message.setTo(email);
        message.setSubject("PassBean corporation");
        message.setText("You link " + link + tokenService.gen_token());
        Sender.send(message);
        log.info("Have a sending massage to " + email);
    }

    public void send_mail(String email, String token){
        message.setFrom("dk6coqznk7gy3ymx@ethereal.email");
        message.setTo(email);
        message.setSubject("PassBean corporation");
        message.setText("You link " + link + token);
        Sender.send(message);
        log.info("Have a sending massage to " + email);
    }
}
