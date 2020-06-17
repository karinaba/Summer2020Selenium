package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeMethod
    public void setUp(){

    }
    @AfterMethod
    public void tearDown(){

    }

    @Test
    public void test1(){
        String exp ="apple";
        String actual = "apple";
        Assert.assertEquals(actual, exp);

    }
    @Test
    public void test2(){
        int num1 =5;
        int num2 =10;
        Assert.assertTrue(num1>num2);
    }
}
