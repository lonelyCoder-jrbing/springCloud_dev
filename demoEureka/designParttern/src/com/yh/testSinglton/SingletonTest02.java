package com.yh.testSinglton;

/*
饿汉式,在类创建时候已经创建了一个单利对象，在保证调用geteinstnce方法之前单例已经就存在了。
 */
public class SingletonTest02 {
    public static SingletonTest02 instance = new SingletonTest02();

    private SingletonTest02() {

    }

    public static SingletonTest02 getInstance() {
        return instance;
    }
}
