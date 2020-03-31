package com.gupao.java_core.annotation.demo5.anno;

import java.lang.annotation.*;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SevenComponent {
    String value() default "";
}
