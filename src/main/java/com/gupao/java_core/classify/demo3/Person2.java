package com.gupao.java_core.classify.demo3;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
public class Person2<T> {

    private T identityCard;

    public void talk(String something){

        System.out.println("我正在说:"+something);

    }

    public Person2(T identityCard){

        this.identityCard = identityCard;

    }
}
