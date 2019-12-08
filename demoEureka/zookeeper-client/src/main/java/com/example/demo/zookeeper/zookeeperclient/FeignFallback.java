package com.example.demo.zookeeper.zookeeperclient;

import org.springframework.stereotype.Component;

@Component
public class FeignFallback implements FeignService {

    @Override
    public String test() {
        return "servie error!";
    }
}