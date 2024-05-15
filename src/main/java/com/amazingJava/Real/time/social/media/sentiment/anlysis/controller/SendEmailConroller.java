package com.amazingJava.Real.time.social.media.sentiment.anlysis.controller;

import com.amazingJava.Real.time.social.media.sentiment.anlysis.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SendEmailConroller {

    @Autowired
    private MailService mailService;

    @GetMapping("send-mail")
    public String sendmail(){
        mailService.sendEmail("jewelcseru@gmail.com","Request for attend the Interview","Dear Jewel\n,You are selected for the position of Jr. software engineer .Please upload your documents.");

        return  "Email send successfully";
    }
}
