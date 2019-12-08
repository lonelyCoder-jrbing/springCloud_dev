package com.yh.facade;

public class DwarvenCartOperator extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.println("catWorker is working ..");
    }

    @Override
    public String name() {
        return "cart worker'name ";
    }
}
