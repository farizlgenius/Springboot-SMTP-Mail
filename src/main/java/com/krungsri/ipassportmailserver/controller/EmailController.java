package com.krungsri.ipassportmailserver.controller;

import com.krungsri.ipassportmailserver.helper.ResponseHelper;
import com.krungsri.ipassportmailserver.schema.BaseResponse;
import com.krungsri.ipassportmailserver.schema.EmailRequest;
import com.krungsri.ipassportmailserver.service.IEmailService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ipassport/api/email")
public class EmailController {
    private static Logger logger = LoggerFactory.getLogger(EmailController.class);

    private IEmailService emailService;

    @Value("${spring.mail.username}")
    private String sender;

    @Value("${service.email.apiKey}")
    private String apiKey;

    @Autowired
    public void setEmailService(IEmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<BaseResponse> sendEmail(@RequestHeader("x-api-key")String xApiKey, @Valid @RequestBody EmailRequest emailRequest, BindingResult bindingResult) {

        BaseResponse res;

        if(!xApiKey.equals(apiKey) || xApiKey.isEmpty() || xApiKey == null){
            res = ResponseHelper.buildResponse(emailRequest.getUuid(),LocalDateTime.now(),400,HttpStatus.BAD_REQUEST,Collections.singletonList("x-api-key is incorrect or not found in headers."));
            logger.error("[BAD_REQUEST] message: x-api-key is incorrect or not found in headers.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }

        if (bindingResult.hasErrors()) {
            List<String> errorMsg = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            res = ResponseHelper.buildResponse(emailRequest.getUuid(),LocalDateTime.now(),400,HttpStatus.BAD_REQUEST,errorMsg);
            logger.error("[BAD_REQUEST] message: {}",errorMsg.stream().collect(Collectors.joining(" , ")));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }

        res = emailService.sendEmail(emailRequest);
        return ResponseEntity.status(res.getStatus()).body(res);
    }


}
