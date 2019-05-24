package com.pemila.annotationdemo.annotation;

import java.lang.annotation.*;

/**
 * 定义Class级别的注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface RecordVisit {
    String visit() default "服务器被访问了一次";
}
