package com.gupao.java_core.collections.list;

import java.util.Iterator;
import java.util.List;

/**
 * @author peng.chen12@hand-china.com
 * @description
 * @date 2020/3/22
 */
public class ThreadIterator extends Thread{

    private List list;

    public ThreadIterator(List list){
        this.list=list;
    }

    @Override
    public void run() {
        while (true){
            Iterator iterator = list.iterator();
            if(iterator.hasNext()) iterator.next();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
