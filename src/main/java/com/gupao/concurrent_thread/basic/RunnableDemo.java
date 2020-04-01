package com.gupao.concurrent_thread.basic;

/**
 * @author jacky
 * @description
 * @date 2020/3/31
 */
public class RunnableDemo implements Runnable {

    public void run() {
        System.out.println("当前线程:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemo());
        thread.start();
    }
}
