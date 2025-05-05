package com.krungsri.ipassportmailserver.controller;

import com.krungsri.ipassportmailserver.schema.EmailDetails;
import com.krungsri.ipassportmailserver.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ipassport/api/email")
public class EmailController {

    private IEmailService emailService;

    @Autowired
    public void setEmailService(IEmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailDetails emailDetail) {
        String status = emailService.sendEmail(emailDetail);
        return status;
    }


}
