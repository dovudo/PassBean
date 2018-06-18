package com.dov.pass.service;

import com.dov.pass.dao.unitInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class Token {

    private static String ip = null;

    @Autowired
    private static unitInterface ui;

    static {
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static String getToken(int leg){
        String ourToken = getRndString(leg);
        //Check collision
        if(ui.checkExistByHash(ourToken) == false)
        getToken(leg);
        return ip + "/#" + ourToken;
    }

    //Generate some random token
    public static String getRndString(Integer lenght) {
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
