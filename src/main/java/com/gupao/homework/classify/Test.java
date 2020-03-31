package com.gupao.homework.classify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacky
 * @description
 * @date 2020/3/29
 */
public class Test {

    public static <T> T getInstance(Class<T> clazz){
        T t = (T)clazz.getSimpleName();
        return t;
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(getInstance(list.getClass()));
        System.out.println(getInstance(String.class));
    }
}

