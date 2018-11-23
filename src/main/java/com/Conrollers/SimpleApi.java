package com.Conrollers;

import com.Service.UnitService;
import com.Service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.*;

import static com.Conrollers.API.STATUS_0;


@RestController
@CrossOrigin
public class SimpleApi {

  /*  @Autowired
    UnitService us;
    private static final Logger log = LoggerFactory.getLogger(SimpleApi.class);
    @GetMapping("/status")
    public String testReq(){
    return ("{\"status\":\"0\"}" + TimeService.get_timestamp_json());
    }

    @PostMapping("/test/persist")
    public String testPersist(@RequestBody String data_json){
        try {us.getIt(data_json);}
        catch (MailSendException e){
            log.error(e.getMessage());
        }
        catch (Exception e){e.printStackTrace();}

        return STATUS_0;
    }

*/
}

