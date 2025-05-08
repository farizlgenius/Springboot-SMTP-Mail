package com.krungsri.ipassportmailserver.schema;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID uuid;
    private LocalDateTime timeStamp;
    private int code;
    private HttpStatus status;
    private List<String> message;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getTimeStamp(){
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp){
        this.timeStamp = timeStamp;
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
