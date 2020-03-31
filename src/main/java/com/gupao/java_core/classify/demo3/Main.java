package com.gupao.java_core.classify.demo3;

import java.util.Date;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
public class Main {

    public static void main(String[] args) {
        //Person实例过程
        Person person= new Person("43333XXXXXXXXXXXXXXXXXX");



        //Person2实例过程
        IdentityCard identityCard=new IdentityCard();
        identityCard.setIdNumber("4323xxxxxxxxxxxxxxxxxxx");
        identityCard.setAddress("湖南xxxxxxxxxxxxxxxxxx");
        identityCard.setStartDate(new Date());
        identityCard.setEndDate(new Date());

        Person2<String> person2= new Person2("3212312312312");//String类型

        Person2<IdentityCard> person3= new Person2(identityCard);//引用类型


    }
}
