package com.example.jdk8.asynctest;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

/*
 * 同步调用：同步就是整个过程是顺序进行的，当各个过程都进行完毕之后，
 * 返回结果。
 * 异步调用：发送了调用的指令，无须等待被调用的方法完全执行完毕，继续执行下面的流程。
 * */
public class TestAsync {

    @Autowired
    private ExceptionHandlingAsyncTaskExecutor exceptionHandlingAsyncTaskExecutor = new ExceptionHandlingAsyncTaskExecutor();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=================main开始==================");
        TestAsync t = new TestAsync();
        t.doSomethingWrong();
        System.out.println("==================main结束==================");

    }

    @Async
    public void doSomethingWrong() throws InterruptedException {
        AppleTree apple = new AppleTree();
        Thread appleThread = new Thread(apple, "apple tree get apple");
        appleThread.start();
        appleThread.join(344);
//      System.out.println("我先弄，你慢慢来。。。。");
//    exceptionHandlingAsyncTaskExecutor.execute(appleThread);

    }

    public static class AppleTree implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println("in autumn apple tree may get many apple");
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
