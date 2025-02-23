package com.zhn.personalproject.baseproject.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyAnnotation {
    @AliasFor("path")
    String value() default "**";

    @AliasFor("value")
    String path() default "**";
}
