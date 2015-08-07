package com.testng;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @Test
    public void testMethod() {
        System.out.println("5. testMethod");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("4. beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("6. afterMethod");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("3. beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("7. afterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("2. beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("8. afterTest");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("1. beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("9. afterSuite");
    }

}
