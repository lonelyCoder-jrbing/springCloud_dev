package com.org.spring.ioctest.beanpostprocessorTest.annotationTest;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Person{
     String name();
     int age();
 }