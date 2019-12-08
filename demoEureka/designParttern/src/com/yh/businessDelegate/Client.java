package com.yh.businessDelegate;

public class Client {

    private BusinessDelegate businessDelegate;

    public Client() {
    }

    public Client(BusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    public void doTask() {
        businessDelegate.doTask();
    }
}
