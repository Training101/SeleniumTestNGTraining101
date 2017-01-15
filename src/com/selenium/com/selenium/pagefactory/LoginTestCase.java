package com.selenium.com.selenium.pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.selenium.pagefactory.HomePage;
import com.selenium.pagefactory.LoginPage;

public class LoginTestCase {
	
	private static WebDriver driver = null;

	
  @Test
  public void loginTC() {
	  
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.submitLogin();
	  loginPage.loginAs("User1", "Password1");
	  HomePage homePage =new HomePage(driver);
	  homePage.checkLoggedInUser("User1");
	  
	   
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
