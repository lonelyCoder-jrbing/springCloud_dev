package com.zookeeper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    private static final UUID INSTANCE_UUID = UUID.randomUUID();


    @GetMapping("/test")
    public String test() {
        log.info("test :" + INSTANCE_UUID.toString());
        return INSTANCE_UUID.toString();
    }
}
