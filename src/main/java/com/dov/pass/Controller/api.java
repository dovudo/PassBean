package com.dov.pass.Controller;


import com.dov.pass.dao.Unit;
import com.dov.pass.dao.unitInterface;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class api {

    @Autowired
    unitInterface ui;

    Gson gson = new Gson();

    @RequestMapping(path = "loginByEmail",
                    method = RequestMethod.POST,
                    consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String login(@RequestParam("e") String email){
        System.out.println(" Valid" );
        Unit unit = ui.getByEmail(email);
        return gson.toJson(unit);
    }
}
