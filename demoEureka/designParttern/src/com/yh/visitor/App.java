package com.yh.visitor;

public class App {

    public static void main(String[] args) {
        ConfiguretionForDos fordos = new ConfiguretionForDos();
        ConfiguretionForUnix forUnix = new ConfiguretionForUnix();
        Heys heys = new Heys();
        heys.accept(fordos);
        heys.accept(forUnix);


        Zoom zoom = new Zoom();
        zoom.accept(fordos);
        zoom.accept(forUnix);


    }
}
