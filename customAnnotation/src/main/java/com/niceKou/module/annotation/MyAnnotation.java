package com.niceKou.module.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE.TYPE, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE.PARAMETER})
public @interface MyAnnotation {
    String value() default "MyAnnotation注解测试";

    String auto() default "false";
}
