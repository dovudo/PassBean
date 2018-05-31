package com.dov.pass.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/get")
public class GetHello {
    /*HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
            .getRequest();
    String ip = request.getRemoteAddr();*/

    private final static Logger log = LoggerFactory.getLogger(GetHello.class);
    @RequestMapping("hello")
    @ResponseBody
    public String home() {
        log.info("GET from " );
        return "Hello World!";
    }
}



