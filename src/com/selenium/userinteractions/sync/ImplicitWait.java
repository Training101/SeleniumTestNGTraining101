package com.selenium.userinteractions.sync;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWait {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //Launch website
        driver.navigate().to("http://www.calculator.net/loan-calculator.html");
        
        WebElement dynamicElement = driver.findElement(By.id("cloanamount"));
        dynamicElement.clear();
        
        //Close the Browser.
        driver.quit();
     }
}
