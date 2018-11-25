package com.selenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PercentCalculator {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.calculator.net");

        // Use page Object library now
        PageObjectsPercCalc.lnk_math_calc(driver).click();
        PageObjectsPercCalc.lnk_percent_calc(driver).click();

        PageObjectsPercCalc.txt_num_1(driver).clear();
        PageObjectsPercCalc.txt_num_1(driver).sendKeys("10");

        PageObjectsPercCalc.txt_num_2(driver).clear();
        PageObjectsPercCalc.txt_num_2(driver).sendKeys("50");

        PageObjectsPercCalc.btn_calc(driver).click();
        String result = PageObjectsPercCalc.web_result(driver).getText();

        if (result.equals("5")) {
            System.out.println(" The Result is Pass");
        } else {
            System.out.println(" The Result is Fail");

        }
        driver.close();
    }
}
