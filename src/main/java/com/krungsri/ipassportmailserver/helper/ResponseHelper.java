package com.krungsri.ipassportmailserver.helper;

import com.krungsri.ipassportmailserver.schema.BaseResponse;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ResponseHelper {

    public ResponseHelper(){}

    public static BaseResponse buildResponse(UUID uuid, LocalDateTime timeStamp, int code, HttpStatus status, List<String> message){
        BaseResponse res = new BaseResponse();
        res.setUuid(uuid);
        res.setTimeStamp(timeStamp);
        res.setStatus(status);
        res.setMessage(message);
        res.setCode(code);
        return res;
    }
}
