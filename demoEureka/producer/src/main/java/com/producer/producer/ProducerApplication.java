package com.producer.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name)
    {
        return "hi " + name + ",i am from port:" + port;
    }
    @RequestMapping("/api")
    public String homeback(@RequestParam String  n)
    {
        int i = Integer.parseInt(n);

        double ret = cut(i);

        return String.valueOf(ret);
    }

    double cut(int n){
        double y=1.0;
        double π=0;
        for(int i=0;i<=n;i++){
             π=3*Math.pow(2, i)*y;
            System.out.println("第"+i+"次切割,为正"+(6+6*i)+"边形，圆周率π≈"+π);
            y=Math.sqrt(2-Math.sqrt(4-y*y));
        }
       return π;
    }

}
