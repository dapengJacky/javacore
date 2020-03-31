package com.gupao.java_core.reflect.demo03;

import java.lang.reflect.Field;

/**
 * @author peng.chen12@hand-china.com
 * @description
 * @date 2020/3/22
 */
public class Boy extends Person{

    private String name;

    private int height;

    public int age;

    public static String text;

    public void playBasketball(){
        System.out.println("playing basketball");
    }

    private void pickUpGirl(){
        System.out.println("追女孩");
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }


    public static void main(String[] args) throws Exception {
        //创建字节码对象的四种方式
        Class clazz = Boy.class;
        Boy boy = (Boy)clazz.newInstance();
        /*Class clazz2 = new Boy().getClass();
        try {
            Class clazz3 = Class.forName("com.gupao.java_core.reflect.demo03.Boy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Class clazz4 = Boy.class.getClassLoader().loadClass("com.gupao.java_core.reflect.demo03.Boy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/


        //Modifier修饰符
        int modifier = clazz.getModifiers();
        System.out.println("修饰符："+modifier);
        try {
            System.out.println("追女孩方法修饰符："+clazz.getDeclaredMethod("pickUpGirl").getModifiers());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("接口:"+clazz.getInterfaces().length);
        System.out.println("注解:"+clazz.getAnnotations().length);
        System.out.println("父类:"+clazz.getSuperclass());

        //Field
        Field[] fields=clazz.getFields();//获取当前类中所有的公有属性，包括继承
        System.out.println("fields:"+fields.length);
        for (int i = 0; i < fields.length ; i++) {
            System.out.println(fields[i].getName());
        }




    }
}
