package com.example.intercepter.impl;

import com.example.intercepter.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {

    // 真实对象
    private Object target;

    // 拦截器全限定名
    private String interceptorClass = null;

    private InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    public static Object bind(Object target, String interceptorClass) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target,interceptorClass));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 如果没有设置拦截器，直接反射原方法
        if (interceptorClass == null){
            return method.invoke(target,args);
        }

        Object result = null;

        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
        if (interceptor.before(proxy,target,method,args)) {
            result = method.invoke(target,args);
        } else {
            interceptor.around(proxy,target,method,args);
        }

        interceptor.after(proxy,target,method,args);

        return result;
    }
}
