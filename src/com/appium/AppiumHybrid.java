package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppiumHybrid {
	
    AppiumDriver driver;
  
    @BeforeMethod
    public void beforeMethod() throws Exception {
    	
    	File apkFile = new File("apk"+File.separator+"eribank.apk");
    	String apkFilePath = apkFile.getAbsolutePath();
        
    	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    	desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFilePath);
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
    	desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
    	desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
    	URL url = new URL("http://127.0.0.1:4723/wd/hub");
    	driver = new AndroidDriver(url, desiredCapabilities);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void testCase() throws InterruptedException {
    	 //Login to the system
         driver.findElement(By.xpath("//android.widget.EditText[@text='Username']")).sendKeys("company");
         driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.experitest.ExperiBank:id/passwordTextField']")).sendKeys("company");
         driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();         
         //Navigate to Make Payment screen
         driver.findElement(By.xpath("//android.widget.Button[@text='Make Payment']")).click();         
         //Enter payment data
         driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("0112345678");
         driver.findElement(By.xpath("//android.widget.EditText[@text='Name']")).sendKeys("John");
         driver.findElement(By.xpath("//android.widget.EditText[@text='Amount']")).sendKeys("2");
         driver.findElement(By.xpath("//android.widget.Button[@text='Select']")).click();         
         //Scroll to the correct country
         driver.scrollTo("Spain");
         driver.findElement(By.xpath("//android.widget.TextView[@text='Spain']")).click();         
         //Send Payment
         driver.findElement(By.xpath("//android.widget.Button[@text='Send Payment']")).click();         
         //Confirm
         driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
         
         
         //Check the available balance
         System.out.println("Current available contexts are : "+driver.getContextHandles());
         driver.context("WEBVIEW_com.experitest.ExperiBank");
         
         System.out.println("Page Source of the Web Context ::: \n*********************\n");
         
         System.out.println(driver.getPageSource());
         String balance = driver.findElement(By.xpath("//h1[@align='center']")).getText();
         System.out.println(balance);
         
         //Switch back to the native context
         driver.context("NATIVE_APP");
         //Logout
         driver.findElement(By.xpath("//android.widget.Button[@text='Logout']")).click();
    } 
    
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
   
}

