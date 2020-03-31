package com.gupao.java_core.annotation.demo6;

import java.lang.annotation.*;

/**
 * this is my first customer annotation
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MySimpleAnno {

}
