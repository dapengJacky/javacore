package com.gupao.concurrent_thread.thread_safe;

import java.io.IOException;

/**
 * @author jacky
 * @description
 * @date 2020/6/9
 */
public class SynchronizedDemo {

    static Integer count=0;

    public static void incr(){
        synchronized (count) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count++;
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        for(int i=0;i<1000;i++){

            new Thread(()->SynchronizedDemo.incr()).start();

        }
        Thread.sleep(5000);

        System.out.println("result:"+count);

    }

}
