package com.gupao.concurrent_thread.operation_method.stop;

import java.util.concurrent.TimeUnit;

/**
 * @author jacky
 * @description 通过一个stop共享变量标识进行线程之间的通信
 * @date 2020/4/1
 */
public class StopDemo {

    private static volatile boolean stop=false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(new StopThread());
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        stop=true;
//        t1.stop();
    }
    static class StopThread implements Runnable{
        @Override
        public void run() {
            while (!stop){
                System.out.println("线程持续运行");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
