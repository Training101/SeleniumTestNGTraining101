package com.selenium.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByLocators {

    public static void main(String[] args) {
        
        
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.calculator.net/mass-calculator.html");
        
        //Finding element with id
        driver.findElement(By.id("cdensity")).sendKeys("10");
        
        //Finding element with name
        driver.findElement(By.name("cdensity")).sendKeys("10");
        
        //Finding element with className
        List<WebElement> byclass = driver.findElements(By.className("mb"));
        for(WebElement e : byclass){
            System.out.println("Found by class name : "+e.getText());
        }
        
        //Finding element with tagName
        WebElement table = driver.findElement(By.id("standard"));
        List<WebElement> row = table.findElements(By.tagName("tr"));
        int rowcount = row.size();
        System.out.println("Row count for the <tr> tags : "+rowcount);
        
        
        //Finding element with xpath
        driver.findElement(By.xpath("//*[@id='standard']/tbody/tr/td/input[@name='cvolume']")).sendKeys("300");
        
        //Finding element with cssSelector
        WebElement calcButton = driver.findElement(By.cssSelector("#cvolume"));
        calcButton.click();
        
        
        //Finding element with linkText
        driver.findElement(By.linkText("Mass Calculator")).click();
        
        //Finding element with partialLinkText
        driver.findElement(By.partialLinkText("Fract")).click();
        
                        
        driver.quit();
        

    }

}
