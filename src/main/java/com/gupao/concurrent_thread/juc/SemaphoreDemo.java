package com.gupao.concurrent_thread.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author jacky
 * @description
 * @date 2020/5/23
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 1; i <=10 ; i++) {
            new Car(i,semaphore).start();
        }

    }

    static class Car extends Thread{
        private int num;

        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("第"+num+"辆车占用车位");
                TimeUnit.SECONDS.sleep(2);//停2s
                System.out.println("第"+num+"辆车开走了");
                semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
