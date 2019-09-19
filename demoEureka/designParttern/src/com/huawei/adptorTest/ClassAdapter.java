package com.huawei.adptorTest;

public class ClassAdapter extends Adaptor implements Target {
    @Override
    public void request() {
          specificRequest();
    }
}
