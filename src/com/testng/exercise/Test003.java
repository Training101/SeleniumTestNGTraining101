package com.testng.exercise;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test003 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @DataProvider
  public Object[][] dt_test003() {
    return new Object[][] {
      new Object[] { "user789","user789", "London", "New York", "December", "Blue Skies Airlines", false },
      new Object[] { "user789","user789", "London", "New York", "December", "Blue Skies Airlines", true },
    };
  }
  
  
  @Parameters("browser")
  @BeforeMethod()
  public void setUp(String browser) throws Exception {
	  if(browser.equals("chrome")) {
	  Runtime.getRuntime().exec("chmod 777 "
				+ "/Users/Pramod/Documents/UCSC_lecture_Masters/MasterProject/SeleniumTestNGTraining101/lib/chromedriver");
		System.setProperty("webdriver.chrome.driver",
				"/Users/Pramod/Documents/UCSC_lecture_Masters/MasterProject/SeleniumTestNGTraining101/lib/chromedriver");
		   driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }else {
		  System.out.println("Not a valid browser");
	  }
  }

  @Test(dataProvider="dt_test003")
  public void test003(String userName,String password, String fromPort, String toPort, String toMonth, String airline, boolean isRetrun) throws Exception {
    driver.get("http://newtours.demoaut.com/");
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys(userName);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.name("login")).click();
    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText(fromPort);
    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText(toPort);
    new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText(toMonth);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Airline:'])[1]/preceding::input[2]")).click();
    new Select(driver.findElement(By.name("airline"))).selectByVisibleText(airline);
    driver.findElement(By.name("findFlights")).click();
    String expected = null;
	String departOrRetrun=null;
    
    if(isRetrun=true) {
     expected = toPort+" to "+fromPort;
     departOrRetrun="RETURN";
    }else {
     expected = fromPort+" to "+toPort;
     departOrRetrun="DEPART";
    }
    	
    assertEquals(driver.findElement(By.xpath("//td/following::b/font[text()='"+departOrRetrun+"']/following::b")).getText(), expected);
    driver.findElement(By.linkText("SIGN-OFF")).click();
  }

  @AfterMethod()
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  
}
