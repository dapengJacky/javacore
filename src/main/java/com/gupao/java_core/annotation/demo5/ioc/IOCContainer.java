package com.gupao.java_core.annotation.demo5.ioc;

import java.util.HashMap;

public class IOCContainer {

    private static HashMap container = new HashMap();

    public static void putBean(String id,Object object){
        container.put(id,object);
    }

    public static Object getBean(String id){
        return container.get(id);
    }

}
