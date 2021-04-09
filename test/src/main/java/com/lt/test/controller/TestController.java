package com.lt.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

/**
 * @author lt
 * @date 2021/3/29 15:50
 */
@Controller
public class TestController {
    @RequestMapping("/index")
    public String index(){
        return "你好";
    }


    @PostMapping("/login")
    public Result login(@RequestParam String userName){
            return null;
    }


}
