package com.demo.aop.app.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@ConditionalOnProperty(name = "before.aspect.enabled", havingValue = "true")
@Aspect
@Component
@Slf4j
public class BeforeAspect implements IAspectService {

    /**
     * Intercepts every method call from any service and prints its parameters
     *
     * @param joinPoint - Intercepted method
     */
    @Before("servicePointcut()")
    public void logCall(JoinPoint joinPoint) {
        log.info("Before aspect triggered for: {}", joinPoint.getSignature().toShortString());
        Arrays.stream(joinPoint.getArgs()).forEach(param -> log.info("Method param: {}", param));
    }

    /**
     * You can also filter by one specific param with args designator
     * which also allows you to handle the arg as an attribute
     *
     * @param joinPoint - Intercepted method
     * @param param     - method param (try changing the type to see which methods get invoked!!!)
     */
    @Before("servicePointcut() && args(param)")
    public void logCallWithOneParam(JoinPoint joinPoint, String param) {
        log.info("Before aspect triggered for: {} with one string param: {}", joinPoint.getSignature().toShortString(), param);
    }

}
