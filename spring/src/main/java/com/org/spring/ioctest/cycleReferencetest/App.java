package com.org.spring.ioctest.cycleReferencetest;

import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.org.spring.ioctest.cycleReferencetest")
public class App {
//address中持有了user对象,而user中持有了address对象
    //启动时会报错:

    /***
     *
     *The dependencies of some of the beans in the application context form a cycle:
     *
     *不过可以探索一下是否可以使用set注入,看这样是否会有cyclereference
     * q1
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
