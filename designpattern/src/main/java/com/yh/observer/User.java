package com.yh.observer;

public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    //每个用户在更新消息的同时会调用读取的方法
    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
