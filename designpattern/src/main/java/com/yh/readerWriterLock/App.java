package com.yh.readerWriterLock;

import java.sql.Time;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<Runnable>(10));
        ReaderWriterLock lock = new ReaderWriterLock();
        IntStream.range(0, 5).forEach(i -> service.submit(new Writer("writer" + i, lock.writeLock(), ThreadLocalRandom.current().nextLong(5000))));


        IntStream.range(0, 5).forEach(i -> service.submit(new Reader(lock.readLock(), "reader" + i, ThreadLocalRandom.current().nextLong(10))));
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        IntStream.range(6, 10).forEach(i -> service.submit(new Reader(lock.readLock(), "reader" + i, ThreadLocalRandom.current().nextLong(10))));

        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }


}
