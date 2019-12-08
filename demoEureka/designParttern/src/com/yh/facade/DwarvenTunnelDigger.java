package com.yh.facade;

public class DwarvenTunnelDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.println("Tunnel worker is working ...");
    }

    @Override
    public String name() {
        return " Tunnel worker's name";
    }
}
