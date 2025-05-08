package com.krungsri.ipassportmailserver.service.Impl;

import com.krungsri.ipassportmailserver.helper.ResponseHelper;
import com.krungsri.ipassportmailserver.schema.BaseResponse;
import com.krungsri.ipassportmailserver.schema.EmailRequest;
import com.krungsri.ipassportmailserver.service.IEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class EmailServiceImpl implements IEmailService {

    private static Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public BaseResponse sendEmail(EmailRequest emailRequest) {
        BaseResponse res;
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailRequest.getReceiver());
            mailMessage.setText(emailRequest.getMessage());
            mailMessage.setSubject(emailRequest.getSubject());
            javaMailSender.send(mailMessage);
            res = ResponseHelper.buildResponse(emailRequest.getUuid(), LocalDateTime.now(),200, HttpStatus.OK, Collections.singletonList("Success."));
            logger.info("[OK] message: Send email success.");
            return res;
        }catch (Exception e){
            logger.error("[INTERNAL_SERVER_ERROR] message: {}", e.getMessage());
            res = ResponseHelper.buildResponse(emailRequest.getUuid(),LocalDateTime.now(),500,HttpStatus.INTERNAL_SERVER_ERROR,Collections.singletonList(e.getMessage()));
            return res;
        }

    }

}
