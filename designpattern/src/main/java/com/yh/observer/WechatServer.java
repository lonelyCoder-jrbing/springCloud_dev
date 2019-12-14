package com.yh.observer;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

public class WechatServer implements Observerable {

    // 面向接口编程
    Vector<Observer> list;
    private String message;


    public WechatServer() {
        this.list = new Vector<Observer>();
    }

    //将需要被通知的对象注册进服务端
    //由于要进行判断list中是否包含该观察者,所以要加锁,防止两个线程同时添加
    @Override
    public synchronized  void registerObserver(Observer o) {
        Assert.notNull(o, "设置观察者不能为空!");
        if (!this.list.contains(o)) {
            this.list.add(o);
        }
    }

    //并且支持用户的添加和移除
    @Override
    public synchronized void removeObserver(Observer o) {
        if (!list.isEmpty()) {
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        //遍历观察者并且进行消息的更新..
        IntStream.range(0, list.size()).forEach(i -> list.get(i).update(message));
    }

    //最重要的是这个set方法,将更新之后的消息赋值给weichatserver中的message属性中,
    //然后调用notifyObserver()方法
    public void setInformation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息  " + s);
        //消息更新,通知所有的观察者
        notifyObserver();
    }
}
