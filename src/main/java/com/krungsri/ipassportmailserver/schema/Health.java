package com.krungsri.ipassportmailserver.schema;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class Health {

    private LocalDateTime timeStamp;
    private String status;

    public Health(){}

    public Health(LocalDateTime timeStamp, String status) {
        this.timeStamp = timeStamp;
        this.status = status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
