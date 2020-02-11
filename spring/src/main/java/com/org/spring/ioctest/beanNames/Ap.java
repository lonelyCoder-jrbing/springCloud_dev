package com.org.spring.ioctest.beanNames;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"com.org.spring.ioctest"})
public class Ap {

    public static void main(String[] args) {
        SpringApplication.run(Ap.class, args);
    }




    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();

//            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

            String[] beanNamesForType = ctx.getBeanNamesForType(Ap.class);
            for(String e:beanNamesForType){
                System.out.println("beanNamesForType------------:"+e);
            }
        };
    }

}