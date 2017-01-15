package com.selenium.keyworddriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PercentCalculatorKeywordDriven extends TestCommands {


	public PercentCalculatorKeywordDriven(WebDriver driver) {
		super(driver);
	}

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		TestCommands commands = new TestCommands(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		open("http://www.calculator.net");
		click(CalcHomePage.lnk_math_calc);
		click(CalcHomePage.lnk_percent_calc);
		type(PercentageCalcPage.txt_num_1, "10");
		type(PercentageCalcPage.txt_num_2, "50");
		waitForElement(PercentageCalcPage.btn_calc);
		click(PercentageCalcPage.btn_calc);

		String result = getElementPropertyToString("textContent",
				PercentageCalcPage.web_result);

		if (result.equals("5")) {
			System.out.println(" The Result is Pass");
		} else {
			System.out.println(" The Result is Fail");

		}
		driver.close();
		driver.quit();
	}
}
