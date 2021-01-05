package com.gupao.concurrent_thread.juc.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author jacky
 * @description
 * @date 2020/5/25
 */
public class ExchangeDemo01 {

    public static void main(String[] args) {
        //1.创建交换机
        Exchanger<String> exchanger = new Exchanger<>();

        //2.利用交换机互换对象
        new Thread(new A(exchanger)).start();
        new Thread(new B(exchanger)).start();
    }
}

class B implements Runnable{
    private Exchanger<String> exchanger = null;
    public B(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("B到达了交换机...");
            String msg = exchanger.exchange("化而为鸟 其名为鹏 鹏之大 需要两个烧烤架");
            System.out.println("B收到了A发送的消息:["+msg+"]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class A implements Runnable{
    private Exchanger<String> exchanger = null;
    public A(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("A到达了交换机...");
            String msg = exchanger.exchange("北冥有鱼 其名为鲲 鲲之大一锅炖不下");
            System.out.println("A收到了B发送的消息:["+msg+"]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
