package com.org.spring.ioctest.beanpostprocessorTest.controller;

import com.org.spring.ioctest.beanpostprocessorTest.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/test")
public class HelloController {
    @Autowired(required = false)
    private CalculateService calculateService;

    private static final Map<String, Integer> wordcountMap = new ConcurrentHashMap<>();

    @GetMapping("/add/{a}/{b}")
    public String add(@PathVariable("a") int a, @PathVariable("b") int b) {
        return "add result : " + calculateService.add(a, b) + ", from [" + calculateService.getServiceDesc() + "]";
    }

    @Bean
    public void getWordCountFromLogFile() {
        System.out.println("read word method has been called here ");
        Map<String, Integer> wordCountFromLogFile = null;

        try {
            wordCountFromLogFile = calculateService.getWordCountFromLogFile();
            wordcountMap.putAll(wordCountFromLogFile);
        } catch (Exception e) {
            System.out.println("read data from log file error");
        }
    }


    @GetMapping("/getWordPair/{word}")
    public String getWordPair(@PathVariable String word) {
        Integer integer = wordcountMap.get(word);
        return word +"   "+ String.valueOf(integer);
    }


}
