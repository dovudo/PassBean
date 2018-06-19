package com.dov.pass.Controller;

import com.dov.pass.dao.Unit;
import com.dov.pass.dao.unitInterface;
import com.dov.pass.service.Mail;
import com.dov.pass.service.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class testController {

    @Autowired
    unitInterface ui;
    @Autowired
    Mail mail;
    Unit unit = new Unit();

    @RequestMapping(path = "test",
            method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        unit.setEmail("tes@dwq.cer");
        unit.setHash(Token.getToken(16));
        unit.setData("FUck me?");
        ui.save(unit);
        return  "test valid";
    }

    @RequestMapping("getToken")
    @ResponseBody
    public String getToken(){
        return Token.getToken(16);
    }

    @RequestMapping("testmail")
    public void testmail(){
        String from = "dovudo98@gmail.com";
        String to = "dovjobs@gmail.com";
        String subject = "JavaMailSender";
        String body = "Fucking Test";

        mail.sendMail(from, to, subject, body);
    }

}
