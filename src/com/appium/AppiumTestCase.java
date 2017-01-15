package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppiumTestCase {
	
    AppiumDriver driver;
  
    @BeforeMethod
    public void beforeMethod() throws Exception {
        
    	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    	desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
    	desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "a69fd414");
    	URL url = new URL("http://127.0.0.1:4723/wd/hub");
    	driver = new AndroidDriver(url, desiredCapabilities);
    	
    }
    
    @Test
    public void testCase() {
    	 driver.get("http://www.wikipedia.org/");
         driver.findElement(By.id("searchInput")).sendKeys("Appium");        
    }    
    
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
   
}

