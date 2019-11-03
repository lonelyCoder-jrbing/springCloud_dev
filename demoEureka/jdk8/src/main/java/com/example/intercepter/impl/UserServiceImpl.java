package com.example.intercepter.impl;

import com.example.intercepter.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void sayHelloworld() {
        System.out.println("hello world!");
    }
}
