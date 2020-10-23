# Spring AOP demo
The objective of this project is to show how Spring AOP can help us break down program logic into modularized
interceptors
## How to run
The application uses a CommandLineRunner class which executes TestMethod from AspectService class.
# Exercises
## 1. Log every method call and params with aspects (BeforeAspect class)
TestMethod has explicit call and param logs. Remove them, set "before.aspect.enabled" property to true and run the application. 
## 2. Log every method completion with aspects (AfterAspectClass)
TestMethod has explicit execution completion logs. Remove those logs, set "after.aspect.enabled" property to true and run the application.
## 3. When does anotherTestMethod gets intercepted?
Check which pointcuts apply to anotherTestMethod and why.
## 4. Log value returned by method with aspects (AfterReturningAspectClass)
TestMethod logs its returned value. Remove that log, set "afterReturning.aspect.enabled" property to true and run the application.
## 5. Intercept exceptions with aspects (ExceptionAspect)
Call TestMethod with a null parameter to make it throw an exception. Set "exception.aspect.enabled" to true and run the app to see if the aspect handles it.
## 6. Measure execution time with an aspect and annotations (MetricAspect)
MetricAspect works for methods annotated with the @MeasureTime annotation. Try putting this annotation on existing or new methods. 
Also, try changing the annotation parameter
## 7. Play with your own pointcuts!
Visit https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#aop and try to create your own pointcuts with different designators 
and  combinations.