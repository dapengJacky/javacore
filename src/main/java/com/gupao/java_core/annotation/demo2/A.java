package com.gupao.java_core.annotation.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class A {

    public A() {
        System.out.println("A 无参构造器被调用了.");
    }

    @Bean("b")
    public static B createBObj() {
        System.out.println("A 的静态方法 createBObj 被调用了.");
        return new B();
    }

    @Bean("c")
    public C createCObj() {
        System.out.println("A 的实例方法 createCObj 被调用了.");
        return new C();
    }

}
