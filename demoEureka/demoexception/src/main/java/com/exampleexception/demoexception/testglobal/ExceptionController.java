package com.exampleexception.demoexception.testglobal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ExceptionController {
    @GetMapping("/exce")
    public String showInfo() {
        System.err.println("dddddddddddddd");
        String info = "你好";
        int a = 1 / 0;
        return info;
    }


}
