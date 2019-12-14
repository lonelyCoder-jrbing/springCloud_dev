package com.yh.readerWriterLock;

import java.io.IOException;
import java.util.concurrent.locks.Lock;

import static com.sun.deploy.perf.DeployPerfUtil.write;

public class Writer implements Runnable {

    private String name;
    private Lock writerLock;
    private long writeTime;

    public Writer(String name, Lock writerLock) {
        this(name, writerLock, 250L);
    }

    public Writer(String name, Lock writerLock, long writeTime) {
        this.name = name;
        this.writerLock = writerLock;
        this.writeTime = writeTime;
    }

    @Override
    public void run() {
        writerLock.lock();
        try {
            write();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writerLock.unlock();
        }
    }

    private void write() throws InterruptedException {
        Thread.sleep(writeTime);
    }
}
