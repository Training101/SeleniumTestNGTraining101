package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppiumWeb {
	
    AppiumDriver driver;
  
    @BeforeMethod
    public void beforeMethod() throws Exception {
        
    	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    	desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
    	desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
    	desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
    	URL url = new URL("http://127.0.0.1:4723/wd/hub");
    	driver = new AndroidDriver(url, desiredCapabilities);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void testCase() {
    	 driver.get("http://www.wikipedia.org/");
         driver.findElement(By.id("searchInput")).sendKeys("Selenium");     
         driver.findElement(By.name("go")).click();   
         String searchResult = driver.findElement(By.xpath("//h1[@id='section_0']")).getText();
         Assert.assertTrue("Selenium".equals(searchResult.trim()));
    }    
    
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
   
}

