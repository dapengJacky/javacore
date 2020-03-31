package com.gupao.java_core.reflect.demo1;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author peng.chen12@hand-china.com
 * @description Class（Method , Field ,SuperClass ,ClassLoader , Package ,Annotation ,Constructor）
 * @date 2020/3/22
 */
public class Dog extends Animal{

    private String color;
    public void bark(){
        System.out.println("Dog barking");
    }

    public static void main(String[] args) throws Exception {
        Class<Dog> clazz = Dog.class;

        //创建对象
        Dog dog = clazz.newInstance();

        //获取类的结构
        System.out.println(clazz.getPackage().getName());//包名 Package
        System.out.println(clazz.getName());//全路径名：包名+类名
        System.out.println(clazz.getSimpleName());//类名
        System.out.println(clazz.getSuperclass());//父类
        System.out.println(clazz.getClassLoader());//类加载器
        System.out.println(Arrays.toString(clazz.getDeclaredMethods()));//所有方法
        System.out.println(clazz.getDeclaredFields()[0].getName());//所有属性包括私有

        Method method = clazz.getDeclaredMethod("bark");
        method.invoke(dog);
    }
}
