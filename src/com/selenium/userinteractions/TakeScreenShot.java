package com.selenium.userinteractions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakeScreenShot {

    public static void main(String[] args) throws IOException
    {
       WebDriver driver = new FirefoxDriver();
       
       // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       // Launch website
       driver.navigate().to("http://www.calculator.net/");
       
       // Maximize the browser
       driver.manage().window().maximize();
       
       File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       
       FileUtils.copyFile(screenshot, new File("screenshots"+File.separator+"screenshots1.jpg"));
       
       driver.quit();
    }
    
}
