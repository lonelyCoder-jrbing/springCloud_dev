package com.org.spring.ioctest.cycleReferencetest;

import org.springframework.beans.factory.support.SimpleInstantiationStrategy;
import org.springframework.stereotype.Component;

@Component
public class User {

    private Address address;

    public User(Address address) {
        System.out.println("user begin  ...");
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
