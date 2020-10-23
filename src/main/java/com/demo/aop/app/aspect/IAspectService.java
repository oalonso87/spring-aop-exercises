package com.demo.aop.app.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Contains common pointcuts and methods for all aspects
 */
public interface IAspectService {

    /**
     * Aspects that use this pointcut will just trigger for services within our package
     * There are other ways to achieve this:
     * Try changing the pointcut to "within(com.demo.aop.app.service..*)"
     * Investigate the differences. Which one is more efficient for our scenario and why?
     * Try also changing the execution designator to things like:
     * execution(String com.demo.aop.app..*Service*.*(..)))
     * execution(* com.demo.aop.app..*Service*.*(String)))
     * execution(* com.demo.aop.app..*Service*.*(Integer)))
     * Which aspects get executed now?
     */
    @Pointcut("execution(* com.demo.aop.app..*Service*.*(..)))")
    default void servicePointcut() {}


}
