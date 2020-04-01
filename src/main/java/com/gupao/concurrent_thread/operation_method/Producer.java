package com.gupao.concurrent_thread.operation_method;

import java.util.Queue;

/**
 * @author jacky
 * @description
 * @date 2020/4/1
 */
public class Producer implements Runnable {

    private final Queue<String> bags;
    private int size;

    public Producer(Queue<String> bags, int size) {
        this.bags = bags;
        this.size = size;
    }

    @Override
    public void run() {
        int i=0;
        while (true){
            i++;
            synchronized (bags){
                while (size==bags.size()){
                    System.out.println("生产者队列bags满了,陷入阻塞");
                    //TODO 阻塞
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
                System.out.println("生产者生产:bag"+i);
                bags.add("bag"+i);
                //TODO 唤醒处于阻塞状态的消费者
                bags.notify();
            }
        }
    }
}
