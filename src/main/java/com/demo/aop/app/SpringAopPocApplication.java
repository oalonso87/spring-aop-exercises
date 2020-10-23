package com.demo.aop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopPocApplication.class, args);
    }

}
