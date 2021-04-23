package com.lt.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author lt
 * @date 2021/4/19 17:50
 */
@Component
@Order(2)
public class MyApplicationRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Runner2>>"+ Arrays.toString(args));
    }
}
