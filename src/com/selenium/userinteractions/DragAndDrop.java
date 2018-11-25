package com.selenium.userinteractions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();
        //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        // Launch website
        driver.navigate().to("http://keenthemes.com/preview/metronic/theme/templates/admin/ui_tree.html");
        
        
        WebElement from = driver.findElement(By.xpath(".//*[@id='j3_7']/a"));
        WebElement to = driver.findElement(By.xpath(".//*[@id='j3_4']/a"));
        
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.dragAndDrop(from, to).build();
        
        dragAndDrop.perform();
        
        //Close the Browser.
        driver.quit();
        
     }
}
