package com.lt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lt
 * @date 2021/4/19 16:56
 */
@RestController
public class HelloController {
    @GetMapping("/helloError")
    public String hello(){
        int i = 1/0;
        return "hello";
    }

    @GetMapping("/hello")
    public String hello1() {
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello2() {
//        System.out.println("hello2");
        return "hello2";
    }
}
