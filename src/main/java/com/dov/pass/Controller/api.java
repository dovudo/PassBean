package com.dov.pass.Controller;


import com.dov.pass.dao.Unit;
import com.dov.pass.dao.unitInterface;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class api {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    unitInterface ui;

    Gson gson = new Gson();

    @RequestMapping(path = "loginbyemail",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String login(@RequestParam("e") String email){
        Unit unit = null;
        log.info("Got request from LOGINBYEMAIL " + email);
        try{
            unit = ui.getByEmail(email);
        }
        catch (NoResultException e)
        {
            return "Can't found entity";
        }
        catch (Exception e){
            log.warn(e.getMessage());
        }
        log.info("Got request by email ");
        return gson.toJson(unit);
    }
}
