package com.demo.aop.app.service;

/**
 * Example service that will be used as a playground for our aspects
 */
public interface AspectService {

    /**
     * This method should just return a random UUID string
     *
     * @param mySuperParam - An example param
     * @return - A random generated UUID string
     */
    String testMethod(String mySuperParam);

    /**
     * This method does nothing but wait one second.
     * It will be used to see when it gets handled by our aspects or not
     *
     * @param param - An example param
     */
    void anotherTestMethod(Integer param);

}
