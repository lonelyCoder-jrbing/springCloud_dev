package com.yh.observer;

public class Test {
    public static void main(String[] args) {

        WechatServer server = new WechatServer();

        Observer userzhang = new User("zhang");
        Observer userLisi = new User("Lisi");
        Observer userWang = new User("wangWu");
        Observer userju = new User("ju");


        server.registerObserver(userLisi);
        server.registerObserver(userzhang);
        server.registerObserver(userWang);

        server.setInformation("python是世界上最好用的语言");

        System.out.println("----------------------------");
        server.removeObserver(userzhang);
        server.setInformation("java是世界上最好用的语言");
        System.out.println("-----------------------------------");
        server.registerObserver(userju);
        server.setInformation("jurongbing is coming...");


    }


}
