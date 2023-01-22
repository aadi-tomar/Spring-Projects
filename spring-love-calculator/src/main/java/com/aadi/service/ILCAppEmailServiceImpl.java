package com.aadi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class ILCAppEmailServiceImpl implements ILCAppEmailService{


    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(String userName, String userEmail, String result) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(userEmail);
        mail.setSubject("Love Calculator App result");
        mail.setText("Hi " + userName + " The result predicted by LCapp is " + result);
        javaMailSender.send(mail);
    }
}
