package com.lt;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author lt
 * @date 2021/4/3 17:30
 */
@SpringBootApplication
public class Chapter01_2 {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Chapter01_2.class);
        builder.bannerMode(Banner.Mode.OFF).run(args);
    }
}
