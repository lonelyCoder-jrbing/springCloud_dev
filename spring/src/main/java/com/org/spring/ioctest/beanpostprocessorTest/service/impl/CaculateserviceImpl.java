package com.org.spring.ioctest.beanpostprocessorTest.service.impl;

import com.org.spring.ioctest.beanpostprocessorTest.service.CalculateService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import static com.org.spring.ioctest.beanpostprocessorTest.utils.FileToWords.stream;

@Service("calculateService")
public class CaculateserviceImpl implements CalculateService {

    private String serviceDesc = "desc from class";


    @Override
    public int add(int a, int b) {
        return a + b;

    }

    @Override
    public String getServiceDesc() {
        return this.serviceDesc;
    }

    @Override
    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    @Override
    public Map<String, Integer> getWordCountFromLogFile() throws IOException {
        return stream("D:\\code\\springCloud\\words")
                .collect(Collectors.groupingBy(e -> e.toLowerCase(),
                        Collectors.summingInt(p -> 1)));
    }


}
