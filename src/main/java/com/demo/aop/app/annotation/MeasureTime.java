package com.demo.aop.app.annotation;

import com.demo.aop.app.aspect.MetricAspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Methods annotated with this annotation will be handled by {@link MetricAspect}
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MeasureTime {

    /**
     * How execution time will be measured for the annotated method. Default is millis
     *
     * @return - Selected format for this annotation
     */
    MeasureEnum measureType() default MeasureEnum.MILLIS;
}
