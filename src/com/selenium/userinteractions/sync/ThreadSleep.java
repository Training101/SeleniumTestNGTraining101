package com.selenium.userinteractions.sync;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ThreadSleep {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();
        
        //Launch website
        driver.navigate().to("http://www.calculator.net");
        
        Thread.sleep(5000); //Will wait for 2 seconds.
        System.out.println("Slept for 5000 milliseconds");
        
        //Close the Browser.
        driver.quit();
     }
}
