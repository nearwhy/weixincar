package com.palm360.airport.util.stereotype;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 主要用于生成redis 外键对应的类
 * 可以描述多个field
 * @author zhangtong
 *
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ForeignKeyList {
	String keyName() default "";
	Class fkClass();
	String fkField();
	String fkValue();
}
