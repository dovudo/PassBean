package com.Service;
import java.util.Random;

import com.dao.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenService {

    @Autowired
    UnitRepository repository;
    private static final int LENGHT = 32;

    public String gen_token(){
            String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() < LENGHT) { // length of the random string.
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            String saltStr = salt.toString();
            if(checkExist(saltStr)) gen_token();
            return saltStr;
    }

    /*
    * Verify token on exist in data base
    * @return true if found similar token
    * */
    private boolean checkExist(String token){
        return repository.findByToken(token) != null;
    }

/*
Method for testing database
* @see Test
* */
    public String gen_email() {
        String SALTCHARS = "qwertyuiopasdfghjklzxcvbnm1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@mail.com";
    }

    public String gen_sha256(){
        return null;
    }
}
