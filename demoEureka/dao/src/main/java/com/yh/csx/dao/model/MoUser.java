package com.yh.csx.dao.model;

import lombok.Data;

@Data
public class MoUser {
    private Long id;
    private int age;
    private String name;

    public MoUser() {
    }

    public MoUser(int age, String name) {
        this.age= age;
        this.name = name;
    }
}
