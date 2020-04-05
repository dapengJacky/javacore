package com.gupao.homework.annotation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacky
 * @description
 * @date 2020/4/5
 */
public class IOCContainer {

    private static final Map<String,Object> ioc = new HashMap<>();

    public static void putBean(String id,Object obj){
        ioc.put(id,obj);
    }

    public static Object getBean(String id){
        return ioc.get(id);
    }
}

