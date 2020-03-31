package com.gupao.java_core.annotation.demo6;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println(Father.class.isAnnotationPresent(MySimpleAnno.class));

        System.out.println(Son.class.isAnnotationPresent(MySimpleAnno.class));
    }
}
