package com.gupao.homework.reflect;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacky
 * @description
 * @date 2020/3/29
 */
public class IocContainer {

    private static final Map map =new HashMap();

    public static void putBean(String id,Object obj){
        map.put(id,obj);
    }

    public static Object getBean(String id){
        return map.get(id);
    }

}
