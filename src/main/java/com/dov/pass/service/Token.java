package com.dov.pass.service;

import com.dov.pass.dao.unitInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class Token {

    @Autowired
    private static unitInterface ui;

    public static String getToken(int leg){
        String ourToken = getRndString(leg);
        //Check collision
        //if(ui.checkExistByHash(ourToken) != true)
        //getToken(leg);
        return  ourToken;
    }

    //Generate some random token
    private static String getRndString(Integer lenght) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < lenght) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
