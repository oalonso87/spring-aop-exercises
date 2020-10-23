package com.demo.aop.app.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "afterReturning.aspect.enabled", havingValue = "true")
@Aspect
@Component
@Slf4j
public class AfterReturningAspect implements IAspectService {

    /**
     * Prints methods' return value
     *
     * @param joinPoint - Intercepted method
     * @param retValue  - Returned value from the intercepted method
     */
    @AfterReturning(pointcut = "servicePointcut()", returning = "retValue")
    public void logReturnObject(JoinPoint joinPoint, Object retValue) {
        log.info("After returning aspect triggered for method {}. Returning value: {}", joinPoint.getSignature().toShortString(), retValue);
    }
}
