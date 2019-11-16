package com.huawei.adptorTest;

public class AdaptorClient {
    public static void main(String[] args) {

        Target client = new ClassAdapter();

        client.request();


    }

}
