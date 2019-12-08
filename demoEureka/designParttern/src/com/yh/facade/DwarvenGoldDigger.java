package com.yh.facade;

public class DwarvenGoldDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.println("gold digger is working");
    }

    @Override
    public String name() {
        return "gold digger's name..";
    }
}
