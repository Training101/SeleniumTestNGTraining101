package com.selenium.datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

    private WebDriver driver;

    @DataProvider(name = "WikiDataProvider")
    public Object[][] WikiDataProviderMehod() {
        return new Object[][] { 
                {"Mango"}, 
                {"Avocado"}, 
                {"Grape"}, 
                {"Apple"},
                {"Papaya"}
        };
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test(dataProvider = "WikiDataProvider")
    public void tcWikipedia(String fruit) throws Exception {
        driver.get("http://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys(fruit);
        driver.findElement(By.className("formBtn")).click();
        String fruitName = driver.findElement(By.xpath("//h1[@id='firstHeading']")).getText();
        Assert.assertTrue(fruit.equals(fruitName.trim()));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
