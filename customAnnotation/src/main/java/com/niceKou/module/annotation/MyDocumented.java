package com.niceKou.module.annotation;

import java.lang.annotation.Documented;

@Documented
public @interface MyDocumented {
    String value() default "Documented注解测试";
}
