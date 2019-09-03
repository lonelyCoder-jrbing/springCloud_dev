package filters;/*
package com.yh.csx.factory.app.filters;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
public class LoggerFilter {
    private static final Logger log = LoggerFactory.getLogger(LoggerFilter.class);
    @Resource
    private Environment environment;

    @Around(value = "execution (* com.yh.csx.factory.app.controller.*.*(..))")
    public Object processApiFacade(ProceedingJoinPoint pjp) {
        String appName;
        try {
            appName = environment.getProperty("spring.application.name").toUpperCase();
        } catch (Exception e) {
            appName = "UNNAMED";
        }
        long startTime = System.currentTimeMillis();
        String name = pjp.getTarget().getClass().getSimpleName();
        String method = pjp.getSignature().getName();
        Object result = null;
        HttpStatus status = null;
        try {
            result = pjp.proceed();
            log.info("RequestTarget : " + appName + "." + name + "." + method);
            if(!method.toLowerCase().contains("import")){
                log.info("RequestParam : " + JSON.toJSON(pjp.getArgs()));
            }
            if (result instanceof ResponseEntity) {
                status = ((ResponseEntity) result).getStatusCode();
            } else {
                status = HttpStatus.OK;
            }
        } catch (Throwable throwable) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            result = new ResponseEntity<>("{\"Internal Server Error\" : \"" + throwable.getMessage() + "\"}", status);
            throwable.printStackTrace();
        } finally {
            log.info("ResponseEntity : {" + "\"HttpStatus\":\"" + status.toString() + "\"" + ",\"ResponseBody\": " + JSON.toJSON(result) + "}");
            log.info("Internal Method Cost Time: {}ms", System.currentTimeMillis() - startTime);
        }
        return result;
    }
}
*/
