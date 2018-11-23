package com.Service;

import org.springframework.stereotype.Service;

import java.util.Random;



public class TokenService {

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
            return saltStr;
    }

    public String gen_sha256(){
        return null;
    }
}
