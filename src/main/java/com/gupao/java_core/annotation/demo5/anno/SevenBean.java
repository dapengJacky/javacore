package com.gupao.java_core.annotation.demo5.anno;

import java.lang.annotation.*;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SevenBean {
    String value() default "";
}
