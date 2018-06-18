package com.dov.pass.Controller;


import com.dov.pass.dao.Unit;
import com.dov.pass.dao.unitInterface;
import com.dov.pass.service.Token;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.persistence.NoResultException;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class api {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    unitInterface ui;

    private Gson gson = new Gson();
    private Unit unit = null;
    @RequestMapping(path = "loginbyemail",
                    method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody String emailJson){

        String email = null;

        try{
            unit = gson.fromJson(emailJson,Unit.class);
            email = unit.getEmail();

            //unit = ui.getByEmail(unit.getEmail());
            log.info("Got request from LOGINBYEMAIL " + gson.toJson(unit));
        }
        catch (NoResultException e)
        {
            return "{\"status\":\"404\"}";
        }
        catch (Exception e){
            log.warn(e.getMessage());
        }
        log.info("Got request by email ");

        //if not exist entity
        if(ui.checkExistByEmail(unit.getEmail())){
            unit.setEmail(email);
            unit.setHash(Token.getToken(16));
        }
        return gson.toJson(unit);
    }

    @RequestMapping(path = "test",
                    method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return  "test valid";
    }

    @RequestMapping("getToken")
    @ResponseBody
    public String getToken(){
        return Token.getToken(16);
    }
}
