package com.demo.aop.app.service.impl;

import com.demo.aop.app.service.AspectService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Service
@Slf4j
public class AspectServiceImpl implements AspectService {

    //TODO: Add MeasureTime annotation for exercise 6 and try with different MeasureEnum types!
    @SneakyThrows
    public String testMethod(String mySuperParam) {
        //TODO: Remove for exercise 6
        Instant startTime = Instant.now();
        //TODO: Remove for exercise 1
        log.info("executeParameterizedMethod() called with param {}", mySuperParam);
        if (mySuperParam == null) {
            throw new RuntimeException("Param must not be null!");
        }
        Thread.sleep(1000);
        String response = UUID.randomUUID().toString();
        try {
            return response;
        } finally {
            //TODO: Remove for exercise 6
            Instant endTime = Instant.now();
            //TODO: Remove for exercise 6
            log.info("Method executed in {} ms ", Duration.between(startTime, endTime).toMillis());
            //TODO: Remove for exercise 2
            log.info("Method ended");
            //TODO: Remove for exercise 4
            log.info("Method returned: {}", response);
        }
    }

    @Override
    @SneakyThrows
    public void anotherTestMethod(Integer param) {
        Thread.sleep(1000);
    }

}
