package com.example.demo.zookeeper.zookeeperclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {
 
    private static final Logger log = LoggerFactory.getLogger(TestController.class);
 
    private static final UUID INSTANCE_UUID = UUID.randomUUID();
 
    @Autowired
    private FeignService feignService;
 
    @GetMapping("/test")
    public String test(){
        log.info("test :" +INSTANCE_UUID.toString());
        return feignService.test();
    }
}
