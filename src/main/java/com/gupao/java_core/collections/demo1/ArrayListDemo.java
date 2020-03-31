package com.gupao.java_core.collections.demo1;

import java.util.*;


public class ArrayListDemo {


    public static void main(String[] args) {

        testRandomAccess();

    }

    /**
     * 测试
     */
    public static void testRandomAccess(){

        ArrayList arrayList=new ArrayList();
        LinkedList linkedList=new LinkedList();

        for (int i = 0; i < 10000000; i++) {
            arrayList.add("seven-"+i);
            linkedList.add("seven-"+i);
        }
        long startTime = System.currentTimeMillis();

        //二分查找的方法..  下标..
        Collections.binarySearch(arrayList,"seven-"+4123123);

        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList的二分查找 : "+(endTime-startTime));

        startTime = System.currentTimeMillis();
        Collections.binarySearch(linkedList,"seven-"+4123123);
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList的二分查找 : "+(endTime-startTime));


    }


















    /**
     * 测试for和iterator在arrayList中的性能差
     */
    public static void testForAndIterator(){
        ArrayList arrayList=new ArrayList();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i <arrayList.size() ; i++) {
            arrayList.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("for循环 : "+(endTime-startTime));


        startTime = System.currentTimeMillis();


        for (Iterator iterator = arrayList.iterator();iterator.hasNext();) {
            iterator.next();
        }

        endTime = System.currentTimeMillis();
        System.out.println("Iterator循环 : "+(endTime-startTime));
    }

}
