package com.lt.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lt
 * @date 2021/3/29 14:44
 */
@RestController
@SpringBootApplication(scanBasePackages = {"com.lt.*"})
public class TaoTaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaoTaoApplication.class,args);
        System.out.println("你好！");
    }
    @RequestMapping
    public String hello() {
        return "hello spring boot!";
    }
}
