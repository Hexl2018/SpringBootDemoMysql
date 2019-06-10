package com.example.demo.sys.controller;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Hexl
 */
@SuppressWarnings("all")
public class BaseController {

    Map success(Object data) {
        Map<String,Object> map = new HashMap<>(3);
        map.put("errMsg","ok");
        map.put("errCode",0);
        map.put("data",data);
        return map;
    }

    Map error(int errCode,String errMsg) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("errMsg",errMsg);
        map.put("errCode",errCode);
        return map;
    }
}
