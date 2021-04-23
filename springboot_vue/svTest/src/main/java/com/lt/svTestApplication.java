package com.lt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author lt
 * @date 2021/4/19 15:49
 */
@SpringBootApplication
@ServletComponentScan
@EnableCaching
@MapperScan(basePackages = "com.lt.mapper")
public class svTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(svTestApplication.class,args);
    }
}
