package com.gupao.java_core.classify.demo5;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
public interface CalGeneric<U> {

    public U add(U num1, U num2);
    public U sub(U num1, U num2);
    public U mul(U num1, U num2);
    public U div(U num1, U num2);

}
