package com.demo.aop.app.aspect;

import com.demo.aop.app.annotation.MeasureEnum;
import com.demo.aop.app.annotation.MeasureTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;


@Aspect
@Component
@Slf4j
public class MetricAspect implements IAspectService {

    @Pointcut("@annotation(measureTime)")
    public void annotationPointcut(MeasureTime measureTime) {}

    /**
     * Calculates execution time from any method that is annotated with {@link MeasureTime}
     *
     * @param joinPoint   - Intercepted method
     * @param measureTime - the measureTime annotation from the intercepted method
     * @throws Throwable - Exception thrown by the join point
     */
    @Around(value = "servicePointcut() && annotationPointcut(measureTime)", argNames = "joinPoint,measureTime")
    public Object measureMethodExeTime(ProceedingJoinPoint joinPoint, MeasureTime measureTime) throws Throwable {
        Instant startTime = Instant.now();
        //Proceed executes the wrapped method and returns its response if any.
        Object retValue = joinPoint.proceed();
        Instant endTime = Instant.now();
        MeasureEnum measureType = measureTime.measureType();
        long executionTime = calculateExecutionTime(Duration.between(startTime, endTime), measureType);
        log.info("Method {} executed in {} {}", joinPoint.getSignature().toShortString(), executionTime, measureTime.measureType().getAbbreviation());
        return retValue;
    }

    /**
     * Calculates method execution time in the given format.
     */
    private long calculateExecutionTime(Duration durationBetween, MeasureEnum measureEnum) {
        switch (measureEnum) {
            case NANOS:
                return durationBetween.toNanos();
            case SECONDS:
                return durationBetween.getSeconds();
            default:
                return durationBetween.toMillis();
        }
    }

}


