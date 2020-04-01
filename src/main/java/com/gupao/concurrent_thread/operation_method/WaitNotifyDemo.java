package com.gupao.concurrent_thread.operation_method;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jacky
 * @description
 * @date 2020/4/1
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {
        Queue<String> bags= new LinkedList<>();
        int size=4;
        Producer producer= new Producer(bags,size);
        Consumer consumer = new Consumer(bags,size);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();

    }
}
