package com.org.spring.ioctest.beanpostprocessorTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.org.spring.ioctest.beanpostprocessorTest")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
