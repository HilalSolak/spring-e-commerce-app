package com.hilalsolak.ecommercespring.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class LoggerHelper {
    public static String convertJsonToString(Object o){
        Gson  gson = new Gson();
        return gson.toJson(o);
    }

    public static Map<String, Object> convertStringToJson(String s)  {
         try{
             Map<String, Object> response = new ObjectMapper().readValue(s, HashMap.class);
             return response;

    }catch (Exception e){
             throw new RuntimeException();
         }
    }
}




