package com.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

    @DataProvider(name = "WikiDataProvider")
    public Object[][] WikiDataProviderMehod() {
        return new Object[][] { 
                {"Mango"}, 
                {"Avocado"}, 
                {"Grape"}, 
                {"Apple"},
                {"Papaya"}
        };
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("I'm in the before method");
    }

    @Test(dataProvider = "WikiDataProvider")
    public void tcWikipedia(String fruit) throws Exception {
        System.out.println("The parameter is : "+fruit);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("I'm in the after method");
        System.out.println("********************************");
    }
}
