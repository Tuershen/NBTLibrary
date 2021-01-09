package com.tuershen.nbtlibrary.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auther Tuershen Create Date on 2021/1/1
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandExecutorAutowired {

    String name();

    int length() default 0;

    String[] permission();

}
