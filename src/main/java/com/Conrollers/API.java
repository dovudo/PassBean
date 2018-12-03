package com.Conrollers;

import com.Service.UnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.Conrollers.ExceptionBrain.*;

@CrossOrigin
@RestController
public class API {

    @Autowired
    private UnitService us;
    private static final Logger logs = LoggerFactory.getLogger(API.class);

    /*
    This method parse json object,
    getting email address as text type
    and try send link with generated token
    to client email address.

    Status info

    0 - All right
    1 - Something wrong
    2 - Invalid address
    4 - Invalid token
    **/
    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    public String SignUp(@RequestBody String data_json) {
        us.ClientAuth(data_json);
        return STATUS_0;
    }

    @PostMapping("/data")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String signIn(@RequestBody String data_json){
        String out = us.takeData(data_json);
        logs.info("Getting data of " + out);
        return out;
    }

    @PutMapping("/data")
    @ResponseStatus(HttpStatus.CREATED)
    public String getUnit(@RequestBody String unit_json){
        String out = us.save(unit_json);
        return out;
    }

}
