package com.gupao.concurrent_thread.thread_safe;

/**
 * @author jacky
 * @description
 * @date 2020/4/6
 */
public class ThreadLocalDemo {

    private static Integer num=0;

//    public static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
//        @Override
//        protected Integer initialValue() {
//            return 0;//初始化num值
//        }
//    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        //希望每个线程都拿到的是0
        for(int i=0;i<5;i++){
            threads[i] = new Thread(()->{
//               num+=5;
                //拿到初始值
//                int num=threadLocal.get();//保证线程之间的隔离性,每个线程内部都有一个ThreadLocalMap（entry数组）存储当前线程的变量
                num+=5;
//                threadLocal.set(num);
                System.out.println(Thread.currentThread().getName()+": "+num);
            },"Thread-"+i);
        }

        for(Thread t:threads){
            t.start();
        }
    }
}
