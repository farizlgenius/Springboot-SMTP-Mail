package com.krungsri.ipassportmailserver.service;

import com.krungsri.ipassportmailserver.schema.EmailDetails;

public interface IEmailService {

    String sendEmail(EmailDetails emailDetails);

}
