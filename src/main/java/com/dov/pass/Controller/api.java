package com.dov.pass.Controller;


import com.dov.pass.dao.Unit;
import com.dov.pass.dao.unitInterface;
import com.dov.pass.service.Mail;
import com.dov.pass.service.Token;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class api {

    @Autowired
    unitInterface ui;
    @Autowired
    Mail mail;
    private Unit unit = new Unit();

    private Gson gson = new Gson();
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "loginbyemail",
                    method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody String emailJson){

        String email;
        unit = gson.fromJson(emailJson,Unit.class);
        email = unit.getEmail();
        log.info(email);
        log.info("Got request from LOGINBYEMAIL " + gson.toJson(unit));

            //if not exist entity
            unit = ui.getByEmail(email);
            unit.setHash(Token.getToken(16));
            ui.save(unit);
            //Send to email auth link
            mail.sendMail("dovudo98@gmail.com", email, "Your authentication link", "http://192.168.0.104:8080/?" + unit.getHash());

        return "{\"status\":\"200\", \"massage\": \"Check your email\"}";
    }

    @RequestMapping(path = "getData",
                    method = RequestMethod.POST)
    @ResponseBody
    public String getData(@RequestParam("e") String token){
        return gson.toJson(ui.getEntityByHash(token));
    }


}
