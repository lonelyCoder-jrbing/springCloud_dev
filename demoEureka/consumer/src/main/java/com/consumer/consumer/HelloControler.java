package com.consumer.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HelloControler {
@Autowired
HelloService helloService;
@RequestMapping(value = "/hi")
public String hi(@RequestParam String name)
{
    return helloService.hiService(name);
}
    @RequestMapping(value = "/hi/getret")
    public String getRet(@RequestParam String n)
    {
        return helloService.getRet(n);
    }




}
