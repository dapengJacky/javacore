package com.gupao.concurrent_thread.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jacky
 * @description
 * @date 2020/5/23
 */
public class LockDemo {

    private static int count=0;
    static Lock lock = new ReentrantLock();//重入锁

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <1000 ; i++) {
            new Thread(LockDemo::incr).start();
        }
        Thread.sleep(3000);
        System.out.println("result:"+count);
    }

    private static void incr() {
        try {
            lock.lock();//获得锁
            Thread.sleep(1);
            count++;//同一时间只会有一个线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//释放锁
        }
    }
}
