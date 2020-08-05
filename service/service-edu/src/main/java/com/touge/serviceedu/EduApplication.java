package com.touge.serviceedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author touge
 * @create 2020-08-03 15:21
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.touge"})
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
