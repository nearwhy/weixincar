package com.palm360.airport.util.stereotype;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EntityKeyName {
	Class entity();

	String keyName() default "";
	
	boolean isCached() default true;
	
	String replicationClass() default "";
}
