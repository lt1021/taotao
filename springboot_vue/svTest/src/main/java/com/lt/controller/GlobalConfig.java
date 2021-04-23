package com.lt.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lt
 * @date 2021/4/19 16:28
 */
@ControllerAdvice
public class GlobalConfig {
    @ModelAttribute(value = "info")
    public Map<String,String> userInfo(){
        Map<String, String> map = new HashMap<>();
        map.put("userName","刘涛");
        map.put("gender","男");
        return map;
    }

    @InitBinder("b")
    public void init(WebDataBinder binder){
        binder.setFieldDefaultPrefix("b.");
    }
    @InitBinder("a")
    public  void init2(WebDataBinder binder){
        binder.setFieldDefaultPrefix("a.");
    }
}
