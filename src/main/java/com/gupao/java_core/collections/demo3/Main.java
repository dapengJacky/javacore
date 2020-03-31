package com.gupao.java_core.collections.demo3;

import java.util.HashMap;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
public class Main {

    public static void main(String[] args) {
        HashMap hashMap=new HashMap();
        hashMap.put(1001,"seven");
        hashMap.put(1002,"rose");

        System.out.println(hash(11111520));
    }


    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
