package com.gupao.concurrent_thread.operation_method.wait_notify.queue;

import java.util.Queue;

/**
 * @author jacky
 * @description
 * @date 2020/4/1
 */
public class Consumer implements Runnable {
    private Queue<String> bags;
    private int size;

    public Consumer(Queue<String> bags, int size) {
        this.bags = bags;
        this.size = size;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bags){
                while (bags.isEmpty()){
                    System.out.println("bags为空,陷入阻塞");
                    try {
                        bags.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String bag = bags.remove();
                System.out.println("消费者消费:"+bag);
                //TODO 唤醒处于阻塞中的生产者
                bags.notifyAll();
            }

        }


    }
}
