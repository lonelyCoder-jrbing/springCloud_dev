package com.yh.testSinglton;

import java.net.BindException;

/*
懒汉式的单例,如果不删除这两个关键字的话，能狗保证线程安全，但是每次访问都需要同步，会影响性能，切回耗费很多的资源，这是懒汉是的缺点。
 */
public class SingletonTest {
    public static volatile SingletonTest instance = null;  //volatile
  static int index = 0;
    //将构造其声明为私有的
    private SingletonTest() {
        System.out.println("创建对象");
    }
    //方法前田间synchronize关键字
    public static synchronized SingletonTest getInstance() {
        if (null == instance) {
            instance = new SingletonTest();
            index++;
            System.out.println("index....."+index);
        }
        return instance;
    }


}
