package com.gupao.reflect.demo03;

import java.lang.reflect.Field;

/**
 * @author peng.chen12@hand-china.com
 * @description
 * @date 2020/3/22
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Class clazz = Boy.class;
        Boy boy = (Boy)clazz.newInstance();

        Field name = clazz.getDeclaredField("name");
        System.out.println("名称name修饰符:"+name.getModifiers());
        name.setAccessible(true);
        name.set(boy,"jacky");
        System.out.println(boy.getName());

        Field height = clazz.getDeclaredField("height");
        height.setAccessible(true);
        height.set(boy,180);
        System.out.println(boy.getHeight());

        Field text = clazz.getDeclaredField("text");
        text.set(null,"这是一个静态属性");
        System.out.println(Boy.text);


    }
}
