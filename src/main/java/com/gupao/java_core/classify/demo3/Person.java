package com.gupao.java_core.classify.demo3;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
public class Person{

    private String identityCard;


    public void talk(String something){

        System.out.println("我正在说:"+something);

    }

    public Person(String identityCard){

        this.identityCard = identityCard;

    }
}
