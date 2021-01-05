package com.gupao.concurrent_thread.juc.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jacky
 * @description
 * @date 2020/5/25
 */
public class ReadWriteLockDemo {
    public static String name = "夏洛";
    public static String gender = "男";

    public static void main(String[] args) {
        ReadWriteLock rwLock = new ReentrantReadWriteLock();

        new Thread(new Thread_A(rwLock)).start();
        new Thread(new Thread_B(rwLock)).start();
        new Thread(new Thread_C(rwLock)).start();
    }
}

class Thread_C implements Runnable{
    private ReadWriteLock rwLock = null;
    public Thread_C(ReadWriteLock rwLock) {
        this.rwLock = rwLock;
    }
    @Override
    public void run() {
        rwLock.writeLock().lock();
        if("夏洛".equals(ReadWriteLockDemo.name)){
            ReadWriteLockDemo.name = "马冬梅";
            ReadWriteLockDemo.gender = "女";
        }else{
            ReadWriteLockDemo.name = "夏洛";
            ReadWriteLockDemo.gender = "男";
        }
        rwLock.writeLock().unlock();
    }
}

class Thread_B implements Runnable{
    private ReadWriteLock rwLock = null;
    public Thread_B(ReadWriteLock rwLock) {
        this.rwLock = rwLock;
    }
    @Override
    public void run() {
        while(true){
            rwLock.readLock().lock();
            System.out.println("B:"+ReadWriteLockDemo.name);
            System.out.println("B:"+ReadWriteLockDemo.gender);
            rwLock.readLock().unlock();
        }
    }
}
class Thread_A implements Runnable{
    private ReadWriteLock rwLock = null;
    public Thread_A(ReadWriteLock rwLock) {
        this.rwLock = rwLock;
    }
    @Override
    public void run() {
        while(true){
            rwLock.readLock().lock();
            System.out.println("A:"+ReadWriteLockDemo.name);
            System.out.println("A:"+ReadWriteLockDemo.gender);
            rwLock.readLock().unlock();
        }
    }
}

