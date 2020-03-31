package com.gupao.java_core.reflect.ioc;

/**
 * @author peng.chen12@hand-china.com
 * @description
 * @date 2020/3/22
 */
public class A {

    public A(){
        System.out.println("A无参构造函数被调用");
    }

    public static B createB(){
        System.out.println("A的静态方法 createB 被调用");
        return new B();
    }

    public C createC(){
        System.out.println("A的实例方法 createC 被调用");
        return new C();
    }
}
