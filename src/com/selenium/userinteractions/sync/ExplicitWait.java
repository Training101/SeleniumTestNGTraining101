package com.selenium.userinteractions.sync;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();
        
        //Launch website
        driver.navigate().to("http://www.calculator.net");
        
        WebElement dynamicElement = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.id("cloanamount")));
        dynamicElement.clear();
        
        //Close the Browser.
        driver.quit();
     }
}
