package com.selenium.userinteractions;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyActions {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();
        
        //Launch website
        driver.navigate().to("http://www.calculator.net/loan-calculator.html");
        
        WebElement dynamicElement = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.id("cloanamount")));
        dynamicElement.clear();
        
        WebElement amount = driver.findElement(By.id("cloanamount"));
        amount.sendKeys("foo");
        
        Thread.sleep(2000);
        amount.clear();
        
        // Set the text to the clip board
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection("blahblahblah"), null);
        
        // perform a key control + v to paste the values in the clip board
        String pasteText = Keys.chord(Keys.CONTROL, "v");
        amount.sendKeys(pasteText);
        
        Thread.sleep(2000);
        
        //Close the Browser.
        driver.quit();
     }
}
