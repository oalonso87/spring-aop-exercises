package com.demo.aop.app.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "after.aspect.enabled", havingValue = "true")
@Aspect
@Component
@Slf4j
public class AfterAspect implements IAspectService {

    /**
     * Intercepts every method call from any service and prints its parameters
     *
     * @param joinPoint - Intercepted method
     */
    @After("servicePointcut()")
    public void logMethodCompletion(JoinPoint joinPoint) {
        log.info("After aspect triggered for method: {} ", joinPoint.getSignature().toShortString());
    }
}
