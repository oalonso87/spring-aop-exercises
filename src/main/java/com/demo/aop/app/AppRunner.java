package com.demo.aop.app;

import com.demo.aop.app.service.AspectService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

    private final AspectService aspectService;


    @Override
    public void run(ApplicationArguments args) {
        //TODO: Change the parameter to null and put this call in a try catch block for exercise 5.
        aspectService.testMethod("DUMMY");
        aspectService.anotherTestMethod(1);
    }
}
