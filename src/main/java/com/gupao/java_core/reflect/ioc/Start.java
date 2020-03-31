package com.gupao.java_core.reflect.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author peng.chen12@hand-china.com
 * @description
 * @date 2020/3/22
 */
public class Start {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
    }
}
