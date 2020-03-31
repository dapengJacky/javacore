package com.gupao.java_core.annotation.demo5.ioc;


import com.gupao.java_core.annotation.demo5.anno.SevenBean;
import com.gupao.java_core.annotation.demo5.anno.SevenComponent;

@SevenComponent
public class A {

    public A() {
        System.out.println("A 无参构造器被调用了.");
    }

    @SevenBean("b")
    public static B createBObj() {
        System.out.println("A 的静态方法 createBObj 被调用了.");
        return new B();
    }

    @SevenBean("c")
    public C createCObj() {
        System.out.println("A 的实例方法 createCObj 被调用了.");
        return new C();
    }

}
