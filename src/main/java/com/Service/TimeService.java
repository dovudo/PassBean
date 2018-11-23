package com.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    public static String get_timestamp_json() {
     return String.format("{\"timestamp\":\"%d\"}", System.currentTimeMillis() / 1000);
    }

    public static long get_timestamp_long(){
        return System.currentTimeMillis() / 1000;
    }

    public static String get_timestamp_str(){
        return Long.toString(get_timestamp_long());
    }

}
