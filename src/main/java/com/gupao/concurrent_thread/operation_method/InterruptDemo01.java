package com.gupao.concurrent_thread.operation_method;

import java.util.concurrent.TimeUnit;

/**
 * @author jacky
 * @description
 * @date 2020/4/1
 */
public class InterruptDemo01 {
    //while
    //线程处于阻塞状态下中断才有意义
    //thread.join
    //thread.wait
    //thread.sleep
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            //默认interrupt属性为false(JVM层面的属性)
            while (!Thread.currentThread().isInterrupted()){
//                System.out.println("中断标识interrupt:"+Thread.currentThread().isInterrupted());
            }
            try {
                TimeUnit.SECONDS.sleep(1);
                InterruptDemo01.class.wait();
            } catch (InterruptedException e) {
                //通过抛异常的方式响应客户端中断请求
                e.printStackTrace();
                System.out.println("线程因阻塞中断");
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();//中断线程
    }
}
