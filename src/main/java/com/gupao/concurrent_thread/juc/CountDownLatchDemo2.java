package com.gupao.concurrent_thread.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author jacky
 * @description 模拟并发操作
 * @date 2020/5/23
 */
public class CountDownLatchDemo2 implements Runnable{

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {

        //构造1000个线程
        for (int i = 0; i < 1000; i++) {
            new Thread(new CountDownLatchDemo2()).start();
        }
        countDownLatch.countDown();
        System.out.println("可以开始表演了");

    }

    @Override
    public void run() {
        try {
            countDownLatch.await();//1000个线程陷入阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
