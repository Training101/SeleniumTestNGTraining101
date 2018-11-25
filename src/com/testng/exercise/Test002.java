package com.testng.exercise;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test002 {
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
  public void test002() throws Exception {
    driver.get("https://www.calculator.net/");
    driver.findElement(By.linkText("Math Calculators")).click();
    driver.findElement(By.linkText("Percentage Calculator")).click();
    driver.findElement(By.id("cpar1")).clear();
    driver.findElement(By.id("cpar1")).sendKeys("5");
    driver.findElement(By.id("cpar2")).clear();
    driver.findElement(By.id("cpar2")).sendKeys("300");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Percentage Calculator'])[3]/following::input[5]")).click();
    assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Result: 15'])[1]/following::b[1]")).getText(), "15");
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
