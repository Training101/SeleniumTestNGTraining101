package com.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTestCase {

  
    @BeforeMethod
    public void beforeMethod() {
        
        System.out.println("I'm in the before method");
    }
    
    @Test
    public void testCase() {
        System.out.println("I'm the test method");
    }    
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("I'm in the after method");
    }
   
}

