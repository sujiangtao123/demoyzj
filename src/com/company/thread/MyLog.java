package com.company.thread;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//注解放置的目标位置,FIELD是将注解在字段级别上
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {
    String description() default "苏江涛";
}
