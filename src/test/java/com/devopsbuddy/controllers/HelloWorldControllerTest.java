package com.devopsbuddy.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;

import static org.junit.Assert.*;

public class HelloWorldControllerTest {

    @Test
    public void sayHello() throws Exception {
        HelloWorldController helloWorldController = new HelloWorldController();
        Assert.assertEquals("index", helloWorldController.sayHello());
    }

}