package com.org.spring.ioctest.beanpostprocessorTest.configerations.SpringMVCInterceptors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {

    @Bean
    public SpringMVCInterceptor springMVCInterceptor() {
        return new SpringMVCInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(springMVCInterceptor()).addPathPatterns("/**");;
    }
}
