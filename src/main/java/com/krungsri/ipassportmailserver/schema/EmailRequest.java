package com.krungsri.ipassportmailserver.schema;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailRequest extends BaseRequest {

    @NotBlank(message = "'subject' field is require in request body.")
    private String subject;
    @NotBlank(message = "'receiver' field is require in request body.")
    @Email(message = "'receiver' field must be a valid email address")
    private String receiver;
    @NotBlank(message = "'message' field is require in request body.")
    private String message;

    public String getSubject(){
        return subject;
    }


    public void setSubject(String subject){
        this.subject = subject;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
