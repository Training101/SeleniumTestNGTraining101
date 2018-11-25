package com.robot;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaRobotExample {

	private WebDriver driver;
	
	@BeforeMethod
    public void beforeMethod() {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
    }
    
    @Test
    public void testCase() throws Exception {
    	
    	driver.get("http://www.wikipedia.org/");
    	
    	Thread.sleep(3000);
    	
    	Robot robot = new Robot();
    	robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_N);
    	robot.keyRelease(KeyEvent.VK_N);
    	robot.keyRelease(KeyEvent.VK_CONTROL);
    	
    	Thread.sleep(5000);
    }    
    
    @AfterMethod
    public void afterMethod() {
    	 driver.quit();
    }
	
}
