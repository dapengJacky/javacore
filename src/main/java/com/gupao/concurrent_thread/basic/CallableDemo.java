package com.gupao.concurrent_thread.basic;

import java.util.concurrent.*;

/**
 * @author jacky
 * @description
 * @date 2020/3/31
 */
public class CallableDemo implements Callable<String> {

    public String call() throws Exception {
        System.out.println("当前线程:"+Thread.currentThread().getName());
        Thread.sleep(3000);
        return "hello jacky";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<String> future = service.submit(new CallableDemo());
        System.out.println("main线程:"+future.get());//get为阻塞方法，被call方法阻塞
    }
}
