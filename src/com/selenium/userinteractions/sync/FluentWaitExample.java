package com.selenium.userinteractions.sync;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        // Launch website
        driver.navigate().to("http://www.calculator.net/loan-calculator.html");

        Wait<WebDriver> wait =
                new FluentWait<WebDriver>(driver)
                        .withTimeout(30, TimeUnit.SECONDS)
                        .pollingEvery(5, TimeUnit.SECONDS)
                        .ignoring(NoSuchElementException.class);

        WebElement dynamicElement = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("cloanamount"));
            }
        });

        dynamicElement.clear();

        // Close the Browser.
        driver.quit();
    }
}
