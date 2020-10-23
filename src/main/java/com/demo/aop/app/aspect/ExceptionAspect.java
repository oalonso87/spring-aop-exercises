package com.demo.aop.app.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@ConditionalOnProperty(name = "exception.aspect.enabled", havingValue = "true")
@Aspect
@Component
@Slf4j
public class ExceptionAspect implements IAspectService {

    /**
     * Intercepts exceptions
     *
     * @param joinPoint - Intercepted method
     * @param ex        - Exception thrown by the intercepted method
     */
    @AfterThrowing(pointcut = "servicePointcut()", throwing = "ex")
    public void interceptException(JoinPoint joinPoint, Exception ex) {
        log.error("Exception aspect triggered for method: {}. Exception detected: {}", joinPoint.getSignature().toShortString(), ex.getMessage());
    }

}
