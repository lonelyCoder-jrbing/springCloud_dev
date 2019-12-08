package com.yh.builder;

public class App {
    public static void main(String[] args) throws Exception {
        Hero doctor = new Hero.Builder("hero", Profession.doctor).setHairStyle(HairStyle.BALD).build();
        System.out.println("doctor:   " + doctor);
    }
}
