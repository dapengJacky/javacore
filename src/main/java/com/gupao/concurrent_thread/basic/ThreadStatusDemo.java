package com.gupao.concurrent_thread.basic;

import java.util.concurrent.TimeUnit;

/**
 * @author jacky
 * @description
 * @date 2020/3/31
 */
public class ThreadStatusDemo {

    public static void main(String[] args) {
        //Time_Waiting状态线程
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Time_Waiting_Demo").start();
        //Waiting状态线程
        new Thread(()->{
            while (true){
                synchronized (ThreadStatusDemo.class){
                    try {
                        ThreadStatusDemo.class.wait();//等待阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Waiting_Demo").start();

        //Blocked状态
        new Thread(new BlockedDemo(),"Blocked_Demo_01").start();
        new Thread(new BlockedDemo(),"Blocked_Demo_02").start();
    }


    static class BlockedDemo extends Thread{
        public void run(){
            synchronized (BlockedDemo.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
