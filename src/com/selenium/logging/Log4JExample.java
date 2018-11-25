package com.selenium.logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Log4JExample {

   static final Logger logger = LogManager.getLogger(Log4JExample.class.getName());
   
   public static void main(String[] args) throws InterruptedException {
   
      DOMConfigurator.configure("log4j.xml");
      logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
      logger.info("TEST Has Started");
      WebDriver driver = new FirefoxDriver();
      
      //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      //Launch website
      driver.navigate().to("http://www.calculator.net/"); logger.info("Open Calc Application");
      
      //Maximize the browser
      driver.manage().window().maximize();
      
      //Click on Math Calculators
      driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a")).click();  logger.info("Clicked Math Calculator Link");
  
      //Click on Percent Calculators
      driver.findElement(By.xpath(".//*[@id='menu']/div[4]/div[3]/a")).click(); logger.info("Clicked Percent Calculator Link");
      
      //Enter value 10 in the first number of the percent Calculator
      driver.findElement(By.id("cpar1")).sendKeys("10"); logger.info("Entered Value into First Text Box");
      
      //Enter value 50 in the second number of the percent Calculator
      driver.findElement(By.id("cpar2")).sendKeys("50");  logger.info("Entered Value into Second Text Box");
      
      //Click Calculate Button
      driver.findElement(By.xpath("//input[@value='Calculate']")).click(); logger.info("Click Calculate Button");
      
      Thread.sleep(5000);
      //Get the Result Text based on its xpath 
      String result = driver.findElement(By.xpath("//p[@class='verybigtext']/font[@color='green']/b")).getText();  logger.info("Get Text Value");
      
      //Print a Log In message to the screen
      logger.info(" The Result is " + result);
      
      if(result.equals("5")) {
         logger.info("The Result is Pass");
      }
      else {
         logger.error("TEST FAILED. NEEDS INVESTIGATION");
      }
      
      logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
      //Close the Browser.
      driver.quit();    
   }
}