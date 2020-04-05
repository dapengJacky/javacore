package com.gupao.concurrent_thread.operation_method.stop;

/**
 * @author jacky
 * @description
 * @date 2020/4/1
 */
public class InterruptDemo02 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("before:"+Thread.currentThread().isInterrupted());
                    Thread.interrupted();//复位标识为false,表示收到了客户端的中断请求，自己决定是否中断
                    System.out.println("after:"+Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();//中断
    }
}
