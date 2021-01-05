package com.gupao.concurrent_thread.operation_method.wait_notify.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author jacky
 * @description
 * @date 2020/5/24
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);
        new Thread(new Consumer(blockingQueue)).start();
        new Thread(new Producer(blockingQueue)).start();

    }


    static class Consumer implements Runnable{
        private BlockingQueue<String> blockingQueue;

        public Consumer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                int i=0;
                while (true){
                    Thread.sleep(5000);//每隔2s消费一次
                    String str = blockingQueue.take();
                    i++;
                    System.out.println("消费者消费第"+i+"个");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Producer implements Runnable{
        private BlockingQueue<String> blockingQueue;

        public Producer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                int i=0;
                while (true){
                    Thread.sleep(2000);//每隔5s生产一次
                    blockingQueue.put("jack");
                    i++;
                    System.out.println("生产者生产第"+i+"个");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
