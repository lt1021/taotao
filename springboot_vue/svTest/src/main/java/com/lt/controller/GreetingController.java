package com.lt.controller;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author lt
 * @date 2021/4/21 11:11
 */
@Controller
public class GreetingController {
    @MessageMapping("/helloSocker")
    @SendTo("/topic/greetings")
    public Message greeting(Message message){
        return message;
    }
}
