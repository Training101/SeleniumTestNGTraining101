package com.selenium.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private final WebDriver driver;

	By usernameLocator = By.xpath("//span[contains(text(),'Welcome')]");
	
    public HomePage(WebDriver driver) {
    	this.driver = driver;
    }
      
    
    public HomePage checkLoggedInUser(String username) {
        
    	driver.findElement(usernameLocator);
    	
        return this;
    }

}
