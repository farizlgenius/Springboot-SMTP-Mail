package com.krungsri.ipassportmailserver.schema;

import lombok.Data;

@Data
public class EmailDetails {

    private String receiver;
    private String msgBody;
    private String subject;
    private String sender;

    public EmailDetails(){}

    public EmailDetails(String receiver, String msgBody, String subject, String sender) {
        this.receiver = receiver;
        this.msgBody = msgBody;
        this.subject = subject;
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
