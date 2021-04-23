package com.lt.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lt
 * @date 2021/4/19 17:11
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @PostMapping("/")
//    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")
    public String addBook(String name){
        return "receice:"+name;
    }
    @DeleteMapping("{id}")
//    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")
    public String deleteBookById(@PathVariable Long id){
        return String.valueOf(id);
    }

    public ModelAndView mav(){

        ModelMap mm = new ModelMap();
        System.out.println(mm);
        return null;
    }
}
