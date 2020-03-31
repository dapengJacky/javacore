package com.gupao.concurrent_thread;

/**
 * @author jacky
 * @description
 * @date 2020/3/31
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("当前线程:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadDemo thread = new ThreadDemo();
        thread.start();
    }
}
