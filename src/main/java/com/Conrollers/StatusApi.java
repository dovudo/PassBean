package com.Conrollers;

import com.Service.TimeService;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
public class StatusApi {

    @GetMapping("/status")
    public String testReq(){
    return ("{\"status\":\"0\"}" + TimeService.get_timestamp_json());
    }

}

