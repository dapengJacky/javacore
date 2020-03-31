package com.gupao.java_core.annotation.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-ioc.xml");


    }
}
