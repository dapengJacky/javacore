package com.gupao.reflect.demo02;

/**
 * @author peng.chen12@hand-china.com
 * @description
 * @date 2020/3/22
 */
public class Test {

    public static void main(String[] args){
        //测试反射和直接new对象的性能差异

        String key = "Word";
        Long start = System.currentTimeMillis();
        for (int i=0;i<1000000;i++){
            Office office=getInstance(key);
//            Office office=getInstanceByReflect(key);
        }
        Long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start));
    }

    private static Office getInstanceByReflect(String key) {
        String packageName = "com.gupao.reflect.demo02";
        Office office=null;
        try {
            Class clazz = Class.forName(packageName + "." + key);
            office=(Office)clazz.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return office;
    }

    private static Office getInstance(String key) {
        if("Word".equals(key)){
            return new Word();
        }

        if("Excel".equals(key)){
            return new Excel();
        }

        if("PPT".equals(key)){
            return new PPT();
        }
        return null;
    }
}
