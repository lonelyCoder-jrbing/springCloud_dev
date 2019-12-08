package com.example.jdk8.streamTest;

import java.util.Optional;

import lombok.Data;

@Data
public class Teacher {

    public Optional<String> name;
    public Optional<Integer> age;
    public Optional<Double> income;

    public Teacher() {
    }


    public Teacher(Optional<String> name, Optional<Integer> age) {
        this.name = name;
        this.age = age;
    }
}
