package com.dov.pass.Controller;


import org.slf4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping("/connect")
public class Connect {
    public static final Logger log = LoggerFactory.getLogger(Connect.class);


    @RequestMapping(path = "getlogin",
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestParam("name") String name, @RequestParam("pass") String pass){
        log.info("To try connect through login {} and password {}",name,pass);
    }
}



