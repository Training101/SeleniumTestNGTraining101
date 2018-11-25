package com.testng.exercise;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test004 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  Runtime.getRuntime().exec("chmod 777 "
				+ "/Users/Pramod/Documents/UCSC_lecture_Masters/MasterProject/SeleniumTestNGTraining101/lib/chromedriver");
		System.setProperty("webdriver.chrome.driver",
				"/Users/Pramod/Documents/UCSC_lecture_Masters/MasterProject/SeleniumTestNGTraining101/lib/chromedriver");
		  driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test003() throws Exception {
    driver.get("http://newtours.demoaut.com/");
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("user789");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("user789");
    driver.findElement(By.name("login")).click();
    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("London");
    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
    new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("December");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Airline:'])[1]/preceding::input[2]")).click();
    new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Blue Skies Airlines");
    driver.findElement(By.name("findFlights")).click();
    assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='RETURN'])[1]/following::font[1]")).getText(), "New York to London");
    driver.findElement(By.linkText("SIGN-OFF")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
