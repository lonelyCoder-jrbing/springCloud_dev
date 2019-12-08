package com.yh.builder;

public enum Profession {

    Teacher, lawer, doctor;

    @Override
    public String toString() {
        return name().toString();
    }
}
