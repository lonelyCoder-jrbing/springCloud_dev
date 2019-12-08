package com.yh.businessDelegate;

public class JmsService implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("do jms service...");
    }
}
