package com.gupao.concurrent_thread.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author jacky
 * @description 控制线程的执行顺序
 * @date 2020/5/23
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(()-> {
            System.out.println("买菜");
            countDownLatch.countDown();
        }
        ).start();
        new Thread(()->{
            System.out.println("洗菜");
            countDownLatch.countDown();
        }
        ).start();
        new Thread(()->{
            System.out.println("切菜");
            countDownLatch.countDown();
        }
        ).start();

        try {
            countDownLatch.await();//阻塞主线程;等待其他线程执行完后，才唤醒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("开始炒菜");

    }
}
