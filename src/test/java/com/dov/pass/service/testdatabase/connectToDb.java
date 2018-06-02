package com.dov.pass.service.testdatabase;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class connectToDb {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private static final String URL = "http://localhost:8080/connect/addempl";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static HttpPost post = new HttpPost(URL);
    private static HttpClient client = new DefaultHttpClient();

    public void sendPOST(String firstname, String secondname) {
        post.setHeader("User-Agent",USER_AGENT);
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("firstname",firstname));
        urlParameters.add(new BasicNameValuePair("lastname", secondname));
        System.out.println(" зашла ли эта хуйня? " + urlParameters);
        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
            HttpResponse response = client.execute(post);
            log.info("\nSending 'POST' request to URL : " + URL);
            log.info("Post parameters : " + post.getEntity());
            log.info("Response Code : " +
                    response.getStatusLine().getStatusCode());
            log.info("urlParameters = " + urlParameters);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
                System.out.println(result.toString());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public  String getRndString(Integer lenght) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
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
