package com.sring.spring.ioctest.impl;

import com.sring.spring.ioctest.CalculateService;
import org.springframework.stereotype.Service;

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
}
