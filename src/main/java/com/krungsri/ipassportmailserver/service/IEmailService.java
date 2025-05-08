package com.krungsri.ipassportmailserver.service;

import com.krungsri.ipassportmailserver.schema.BaseResponse;
import com.krungsri.ipassportmailserver.schema.EmailRequest;

public interface IEmailService {

    BaseResponse sendEmail(EmailRequest emailRequest);

}
