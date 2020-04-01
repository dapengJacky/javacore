package com.gupao.concurrent_thread.operation_method;

/**
 * @author jacky
 * @description Thread.join()方法保证当前线程执行结果的可见性
 * @date 2020/4/1
 */
public class ThreadJoinDemo {

    private static int i=0;
    private static int x=0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            i=1;
            x=2;
        });
        Thread t2 = new Thread(()->{
           i=x+2;
        });

        t1.start();
        //t1的执行结果对t2可见(t1线程一定比t2线程优先执行)
        t1.join();//阻塞主线程,当t1线程执行结束后会notifyAll,唤醒后t2才会执行，保证了线程执行结果的可见性
        t2.start();

        Thread.sleep(1000);
        System.out.println("i="+i);
    }
}
