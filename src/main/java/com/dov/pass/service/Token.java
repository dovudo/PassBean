package com.dov.pass.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class Token {

    private static String ip = null;

    static {
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static String getToken(int leg){
        return ip + "/#" + getRndString(leg);
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
