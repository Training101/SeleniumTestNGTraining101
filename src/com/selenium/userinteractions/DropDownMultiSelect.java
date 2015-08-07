package com.selenium.userinteractions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DropDownMultiSelect {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();
        //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        driver.navigate().to("http://demos.devexpress.com/aspxeditorsdemos/ListEditors/MultiSelect.aspx");

        //driver.manage().window().maximize();
        driver.findElement(By.id("ContentHolder_lbSelectionMode_I")).click();
        driver.findElement(By.id("ContentHolder_lbSelectionMode_DDD_L_LBI1T0")).click();
        Thread.sleep(5000);
        
        // Perform Multiple Select
        Actions builder = new Actions(driver);
        WebElement select = driver.findElement(By.id("ContentHolder_lbFeatures_LBT"));
        List<WebElement> options = select.findElements(By.tagName("td"));
        
        System.out.println(options.size());
        Action multipleSelect = builder.keyDown(Keys.CONTROL).click(options.get(2)).click(options.get(4)).click(options.get(6)).build();
        
        multipleSelect.perform();
        
        Thread.sleep(5000);
        //Close the Browser.
        driver.quit();
     }
}
