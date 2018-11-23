package com.Conrollers;

import com.Model.Unit;
import com.Service.TimeService;
import com.Service.UnitService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class API {

    @Autowired
    private UnitService us;
    private static final Logger logs = LoggerFactory.getLogger(API.class);
    private String email;
    public static final String STATUS_0 = "{\"status\":\"0\"} ";
    public static final String STATUS_1 = "{\"status\":\"Invalid address\"}";
    public static final String STATUS_2 = "{\"status\":\"Something happened wrong!\"}";
    /*

    This method parse json object,
    getting email address as text type
    and try send link with generated token
    to client email address.

    Status info

    0 - All right
    1 - Something wrong
    2 - Invalid address

    * */

    @PostMapping("/auth")
    public String SignUp(@RequestBody String data_json) {
        try {
            us.getIt(data_json);
        } catch (MailSendException me) {
            logs.warn("Invalid address " + email);
            return STATUS_1;
        } catch (Exception e) {
            logs.error(e.getMessage());
            e.printStackTrace();
            return STATUS_2;
        }
        return HttpStatus.OK + TimeService.get_timestamp_json();
    }


    @PostMapping("/dog")
    public String signIn(@RequestBody String data_json){
        String out = us.getIt(data_json);
        logs.info("Getting data of " + out);
        return out;
    }


/*
* Should get
* how to work with it
* */
    @ExceptionHandler(MailSendException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private String ExceptionMailSend(Exception e){
        return STATUS_1;
    }
}
