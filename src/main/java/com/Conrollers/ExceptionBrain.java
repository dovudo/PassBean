package com.Conrollers;

import com.Service.TimeService;
import com.google.gson.stream.MalformedJsonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionBrain {

    public static final String STATUS_0 = "{\"status\":\"0\", \"timestamp\":\"" + TimeService.get_timestamp_str() +"\"} ";
    public static final String STATUS_1 = "{\"status\":\"Invalid address\"}";
    public static final String STATUS_2 = "{\"status\":\"Something going wrong!\"}";
    public static final String STATUS_4 = "{\"status\":\"Invalid token\", " +
            "\"msg\":\"You need get " +
            "login\"}";

    private static final Logger log = LoggerFactory.getLogger(ExceptionBrain.class);

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private @ResponseBody String EntityEx(){
        return STATUS_4;
    }

    @ExceptionHandler(MailSendException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private @ResponseBody String MailEx(MailSendException me){
    log.error(me.getMessage());
    return "{\"status\":\"Mail send error\"}";
    }

    @ExceptionHandler(MalformedJsonException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private @ResponseBody String JsonSyntaxExceptin(){
        log.warn("Json syntax error");
        return "{\"status\":\"Json syntax error\"}";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    private void AllExceptions(Exception e){
        e.printStackTrace();
    }
}
