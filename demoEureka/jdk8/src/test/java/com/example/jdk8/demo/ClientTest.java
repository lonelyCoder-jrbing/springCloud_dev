package com.example.jdk8.demo;

import com.example.intercepter.UserService;
import com.example.intercepter.impl.InterceptorJdkProxy;
import com.example.intercepter.impl.UserServiceImpl;

public class ClientTest {

    public static void main(String[] args) {
        UserService userServiceProxy = (UserService) InterceptorJdkProxy
                .bind(new UserServiceImpl(), "com.example.intercepter.impl.InterceptorImpl");
        userServiceProxy.sayHelloworld();
    }

}
