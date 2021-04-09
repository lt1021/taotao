package com.lt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lt
 * @date 2021/4/3 16:54
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return  "你好！";
    }
}
