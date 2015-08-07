package com.selenium.datadriven.fileread;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.PropertyFileReader;

public class ReadPropertyFileExample {

    WebDriver driver;
    
    String PROPERTY_FILE_NAME = "config.properties";    
    PropertyFileReader reader;
    
    @BeforeMethod
    public void beforeMethod() {
        
    	reader = new PropertyFileReader(PROPERTY_FILE_NAME);
    	
        String browser = reader.getPropertyValue("BROWSER");
        
        if("Firefox".equals(browser)){
            driver = new FirefoxDriver();
        } else {
            throw new Error("Unsupported browser name : "+browser);
        }
        
        driver.manage().window().maximize();
    }
    
    @Test
    public void testCase() {

    	String url = reader.getPropertyValue("URL");
        driver.get(url);
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Google", pageTitle);
    }    
    
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    
    
    
   
}

