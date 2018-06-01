package com.dov.pass.Controller;


import com.dov.pass.dao.persistEmployee;
import com.dov.pass.service.employee;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping("/connect")
public class Connect {
    public static final Logger log = LoggerFactory.getLogger(Connect.class);

    @Autowired
    private static persistEmployee ei;

    @RequestMapping(path = "addempl",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void addempl(@RequestParam("firstname") String fname, @RequestParam("lastname") String lname){

        employee emp = new employee();
        log.info("add to bd {} {}",fname,lname);
        emp.setFirstName(fname);
        emp.setLastName(lname);
        ei.save(emp);
    }

    @RequestMapping(path = "getlogin",
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestParam("name") String name, @RequestParam("pass") String pass){
        log.info("To try connect through login {} and password {}",name,pass);
    }
}



