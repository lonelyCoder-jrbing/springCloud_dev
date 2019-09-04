package com.example.demo.zookeeper.zookeeperclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "zookeeper-server",fallback = FeignFallback.class)
public interface FeignService {
 
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test();
}
