package com.selenium.userinteractions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextBoxInteractions {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();
        // Puts a Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Launch website
        driver.navigate().to("http://www.calculator.net/percent-calculator.html");
        
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("1010");
        
        Thread.sleep(5000);
        
        // Get the text box from the application
        String result = driver.findElement(By.id("cpar1")).getAttribute("value");
        
        // Print a Log In message to the screen
        System.out.println(" The Result is " + result);
        
        // Close the Browser.
        driver.quit();

    }

}
