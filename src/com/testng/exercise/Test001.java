package com.testng.exercise;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test001 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@DataProvider
	  public Object[][] dt_test001() {
	    return new Object[][] {
	      new Object[] { "5", "200","10" },
	      new Object[] { "5", "300","15" },
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
		}
		else {
			System.out.println("Not a valid browser");
		}
	}

	@Test(dataProvider="dt_test001")
	public void test001(String input1, String input2,String expected) throws Exception {
		driver.get("https://www.calculator.net/");
		driver.findElement(By.linkText("Math Calculators")).click();
		driver.findElement(By.linkText("Percentage Calculator")).click();
		driver.findElement(By.id("cpar1")).clear();
		driver.findElement(By.id("cpar1")).sendKeys(input1);
		driver.findElement(By.id("cpar2")).clear();
		driver.findElement(By.id("cpar2")).sendKeys(input2);
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Percentage Calculator'])[3]/following::input[5]"))
				.click();
		assertEquals(driver
				.findElement(By.xpath(
						"(.//*[normalize-space(text()) and normalize-space(.)='Result: 10'])[1]/following::b[1]"))
				.getText(), expected);

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
