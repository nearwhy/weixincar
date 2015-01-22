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
@Deprecated
public @interface ForeignKeyClass {
	/**
	 * 对应的表名
	 * @return
	 */
	String tableName() default "";
	/**
	 * 对应的外键名
	 * @return
	 */
	String fk() default "";
	/**
	 * 对应的外键表中的字段的内容
	 * @return
	 */
	String fkFieldName() default "";
}
