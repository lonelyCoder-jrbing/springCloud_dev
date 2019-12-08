package com.example.jdk8.streamTest.lambdaTest.impl;


import com.example.jdk8.streamTest.Student;
import com.example.jdk8.streamTest.lambdaTest.TestInterface.FunctionalInterfaceTest;

public class FunctionImpl implements FunctionalInterfaceTest {


    @Override
    public void getName(Student x) {
        System.out.println("hello world" + x);
    }
}
