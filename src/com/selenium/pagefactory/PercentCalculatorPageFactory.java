package com.selenium.pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class PercentCalculatorPageFactory {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.calculator.net");

        CalcHomePage homePage = PageFactory.initElements(driver, CalcHomePage.class);
        homePage.clickMathCalcLink();
        homePage.clickPercentCalcLink();
        
        PercentageCalcPage percentageCalcPage = PageFactory.initElements(driver, PercentageCalcPage.class);
        percentageCalcPage.enterInputValuesAndCalculate("10", "50");
        String result = percentageCalcPage.getCalculatedValue();
        
        if (result.equals("5")) {
            System.out.println(" The Result is Pass");
        } else {
            System.out.println(" The Result is Fail");

        }
        
        driver.close();
    }
}
