package com.example.jdk8.jdk8Thingking.concurrent;

import com.example.jdk8.generalTypeTest.App;
import com.sun.deploy.util.ReflectionUtil;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletedMachina {

    public static void main(String[] args) {
        CompletableFuture<Machina> cf =
                CompletableFuture.completedFuture(
                        new Machina(0));
        try {
            Machina m = cf.get();  // Doesn't block
            System.out.println(m);
        } catch (InterruptedException |
                ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


}
