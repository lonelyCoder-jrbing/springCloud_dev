package com.consumer.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
   可以访问生产者提供的方法
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String getRet(String n) {
        String in = null;
        try {
            in = restTemplate.getForObject("http://SERVICE-HI/api?n=" + n, String.class);
        } catch (Exception e) {
            System.out.println("e:   " + e);
        }
        System.out.println(in);
        if (null != in) {
            return restTemplate.getForObject("http://SERVICE-HI/api?n=" + n, String.class);
        }
        return "";
    }

    public String hiError(String name) {
        return "hey " + name + ", there is a problem with hi page!";
    }

}
