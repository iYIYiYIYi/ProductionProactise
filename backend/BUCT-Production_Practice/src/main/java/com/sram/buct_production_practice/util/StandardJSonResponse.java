package com.sram.buct_production_practice.util;

import com.alibaba.fastjson.JSONObject;
import springfox.documentation.spring.web.json.Json;

public class StandardJSonResponse {
    public static JSONObject Convert(Object data,String message,int code){
        JSONObject obj =  new JSONObject();
        obj.put("code",code);
        obj.put("message",message);
        obj.put("data",data);
        return obj;
    }

    public static JSONObject Correct(Object data,String message){
        return Convert(data,message,200);
    }
    public static JSONObject Error(String message){
        return Convert(null,message,500);
    }
}
