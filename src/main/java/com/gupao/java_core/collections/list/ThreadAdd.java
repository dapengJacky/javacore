package com.gupao.java_core.collections.list;

import java.util.List;

/**
 * @author peng.chen12@hand-china.com
 * @description
 * @date 2020/3/22
 */
public class ThreadAdd extends Thread{

    private List list;

    public ThreadAdd(List list){
        this.list=list;
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println("loop execute: "+i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(i);//modCount++   -> 快速失败机制检测
        }
    }
}
