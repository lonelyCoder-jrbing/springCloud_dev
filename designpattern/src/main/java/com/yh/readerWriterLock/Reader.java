package com.yh.readerWriterLock;

import java.util.concurrent.locks.Lock;

public class Reader implements Runnable {

    private Lock readerLock;
    private String name;
    private long readTime;

    public Reader(Lock readerLock, String name, long readTime) {
        this.readerLock = readerLock;
        this.name = name;
        this.readTime = readTime;
    }

    public Reader(Lock readerLock, String name) {
        this(readerLock, name, 250L);
    }


    @Override
    public void run() {
        readerLock.lock();
        try {
            read();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } finally {
            readerLock.unlock();
        }
    }

    private void read() throws InterruptedException {
        System.out.println(String.format(name, "   begin"));
        Thread.sleep(readTime);
        System.out.println(String.format(name, "end"));
    }

}
